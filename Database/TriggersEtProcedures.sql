----retire du solde quand on ajoute un paiement

CREATE OR REPLACE TRIGGER AjoutPaiementSolde
AFTER INSERT ON SAE_PAIEMENT
FOR EACH ROW
BEGIN
    UPDATE SAE_CONTRATLOCATION
    SET Solde = Solde + :NEW.Montant
    WHERE Numero_de_contrat = :NEW.fk_Numero_de_contrat;
END;
/



CREATE OR REPLACE PROCEDURE VerifierDateLancement IS

    --Verifie la derniere date de lancement et mets a jour le solde en fonction des 
    --loyers et charges qui n etaient pas ajoute
    --les charges sont calcules independemment 
    v_date   DATE;
    v_annees NUMBER;
    v_mois   NUMBER;
    v_count NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_count
    FROM SAE_DateDernierLancement
    WHERE Id_Lock = 'X';

    IF v_count = 0 THEN
        RETURN; 
    END IF;
    SELECT TRUNC(date_dernier_lancement,'MM')
    INTO v_date
    FROM SAE_DateDernierLancement
    WHERE Id_Lock = 'X';

    v_annees := FLOOR(MONTHS_BETWEEN(TRUNC(SYSDATE,'MM'), v_date) / 12);

    IF v_annees > 0 THEN
        UPDATE SAE_ContratLocation
        SET Solde = Solde - (Montant_Mensuel * v_annees * 12 + Provision_Charge*v_annees*12);
        v_date := ADD_MONTHS(v_date, v_annees * 12);
    END IF;
    v_mois := MONTHS_BETWEEN(TRUNC(SYSDATE,'MM'), v_date);

    IF v_mois > 0 THEN
        UPDATE SAE_ContratLocation
        SET Solde = Solde - (Montant_Mensuel * v_mois + Provision_Charge*v_mois);
        
         v_date := ADD_MONTHS(v_date, v_mois);
    END IF;

    UPDATE SAE_DateDernierLancement
    SET date_dernier_lancement = v_date
    WHERE Id_Lock = 'X';

    COMMIT;
END VerifierDateLancement;
/





--Permet de creer une date d anniversaire automatiquement quand on creer un contrat de location
CREATE OR REPLACE TRIGGER DateAnniversaireAuto
AFTER INSERT ON SAE_ContratLocation 
FOR EACH ROW
BEGIN
    INSERT INTO SAE_DateAnniversaireContrat (
        fk_Numero_de_contrat,
        Date_dernier_anniversaire
    )
    VALUES (
        :NEW.Numero_de_contrat,
        :NEW.Date_debut
    );
END;
/


--Calcul la difference entre les charges réels et les provisions de charges
-- à utiliser à la fin d'un contrat contrairement a VerifierDateAnniversaire
create or replace FUNCTION calcul_regularisation_contrat (
    p_annee     IN NUMBER,
    p_contrat   IN VARCHAR2
) RETURN NUMBER
IS
    v_total_provisions      NUMBER := 0;
    v_total_charges         NUMBER := 0;
BEGIN

    SELECT NVL(COUNT(p.Id_Paiement) * cl.Provision_Charge, 0)
    INTO v_total_provisions
    FROM MSF5131A.SAE_Paiement p,
         MSF5131A.SAE_ContratLocation cl
    WHERE p.fk_Numero_de_contrat = cl.Numero_de_contrat
      AND cl.Numero_de_contrat = p_contrat
      AND EXTRACT(YEAR FROM p.Date_Paiement) = p_annee
    GROUP BY cl.Provision_Charge;

    SELECT
        NVL(cg.Total_Charges_Generales, 0)
      + NVL(c.Total_Compteurs, 0)
      + NVL(f.Total_Factures, 0)
    INTO v_total_charges
    FROM
        MSF5131A.SAE_ContratLocation cl,
        MSF5131A.SAE_BienLouable b,
        (
            SELECT fk_Id_BienLouable,
                   SUM(Montant_Total) AS Total_Charges_Generales
            FROM MSF5131A.SAE_Charges_Generale
            WHERE EXTRACT(YEAR FROM Date_Charge) = p_annee
            GROUP BY fk_Id_BienLouable
        ) cg,
        (
            SELECT fk_Id_BienLouable,
                   SUM(Total) AS Total_Compteurs
            FROM MSF5131A.SAE_Compteur
            GROUP BY fk_Id_BienLouable
        ) c,
        (
            SELECT fk_Id_BienLouable,
                   SUM(Montant) AS Total_Factures
            FROM MSF5131A.SAE_Facture
            WHERE EXTRACT(YEAR FROM Date_de_facture) = p_annee
            GROUP BY fk_Id_BienLouable
        ) f
    WHERE cl.Numero_de_contrat = p_contrat
      AND cl.fk_Id_BienLouable = b.Id_BienLouable
      AND b.Id_BienLouable = cg.fk_Id_BienLouable(+)
      AND b.Id_BienLouable = c.fk_Id_BienLouable(+)
      AND b.Id_BienLouable = f.fk_Id_BienLouable(+);

    RETURN v_total_charges - v_total_provisions;
    
    -- Solde_Regularisation > 0  -> le locataire doit payer
    -- Solde_Regularisation < 0  -> le proprietaire rembourse
    -- Solde_Regularisation = 0  -> aucun probleme

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;




    --Verifie la derniere date d anniversaire et si un an s est ecoule soustrait les provisions de charge en fonction des 
    --charges reeles puis l'ajoute au solde
    --Met a jour la date d anniversaire
    --On a creer cette procedure car on ne pouvait pas creer un schedule
CREATE OR REPLACE PROCEDURE VerifierDateAnniversaire IS
    v_annees        NUMBER;
    v_date          DATE;
    v_total_charges NUMBER;
    v_dummy NUMBER;
    v_count NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_count
    FROM SAE_DateAnniversaireContrat;

    IF v_count = 0 THEN
        RETURN;
    END IF;

    FOR i IN (
            --dac = Date Anniversaire Contrat
             --cl = Contrat Location
        SELECT dac.fk_Numero_de_contrat,
               TRUNC(dac.Date_dernier_anniversaire, 'MM') AS date_anniv,
               cl.Provision_Charge,
               cl.fk_Id_BienLouable
        FROM SAE_DateAnniversaireContrat dac
        JOIN SAE_ContratLocation cl
             ON cl.Numero_de_contrat = dac.fk_Numero_de_contrat
    ) LOOP

        v_date := i.date_anniv;


        v_annees := EXTRACT(YEAR FROM TRUNC(SYSDATE)) - EXTRACT(YEAR FROM v_date);


        v_date := ADD_MONTHS(v_date, v_annees * 12);

        IF v_date > TRUNC(SYSDATE) THEN
            v_annees := v_annees - 1;
            v_date := ADD_MONTHS(v_date, -12);
        END IF;


        IF v_annees >= 1 THEN

            SELECT NVL(SUM(cg.Montant_Total), 0)
            INTO v_total_charges
            FROM SAE_Charges_Generale cg
            WHERE cg.fk_Id_BienLouable = i.fk_Id_BienLouable;


            UPDATE SAE_ContratLocation
            SET Solde = Solde - ((i.Provision_Charge - v_total_charges) * 12 * v_annees)
            WHERE Numero_de_contrat = i.fk_Numero_de_contrat;


            UPDATE SAE_DateAnniversaireContrat
            SET Date_dernier_anniversaire = v_date
            WHERE fk_Numero_de_contrat = i.fk_Numero_de_contrat;
        END IF;

    END LOOP;

    COMMIT;
END VerifierDateAnniversaire;
/




--Empeche la suppression d un contrat si il reste un solde
CREATE OR REPLACE TRIGGER SoldeImpaye
BEFORE DELETE ON SAE_ContratLocation
FOR EACH ROW
BEGIN
    IF :OLD.Solde != 0 THEN
        RAISE_APPLICATION_ERROR(-20012, 'Il reste un solde!');
    END IF;
END;
/


--Empeche la suppression d un locataire sous contrat
CREATE OR REPLACE TRIGGER InterdictionSuppressionLocataireContrat
BEFORE DELETE ON SAE_Locataire
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_count
    FROM SAE_Contrat_Locataire
    JOIN SAE_ContratLocation ON SAE_ContratLocation.Numero_de_contrat = SAE_Contrat_Locataire.Numero_de_contrat
    WHERE SAE_Contrat_Locataire.Id_Locataire = :OLD.Id_Locataire
      AND SAE_ContratLocation.solde IS NOT NULL;

    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(
            -20010,
            'Suppression interdite : Il y''a toujours un contrat lie a ce locataire'
        );
    END IF;
END;
/




--Recupere la plus grande annee et le dernier trimestre de IRL
-- pour savoir avec quelle valeur il faut multiplier le loyer
CREATE OR REPLACE FUNCTION get_max_irl RETURN NUMBER IS
    v_valeur NUMBER;
BEGIN
    SELECT IRL
    INTO v_valeur
    FROM SAE_IRL
    WHERE Annee = (SELECT MAX(Annee) FROM SAE_IRL)
      AND Trimestre = (
          SELECT MAX(Trimestre)
          FROM SAE_IRL
          WHERE Annee = (SELECT MAX(Annee) FROM SAE_IRL)
      );

    RETURN v_valeur;
END;
/




--Permet de mettre a jour le contrat en fonction de la valeur de IRL
CREATE OR REPLACE PROCEDURE maj_montant_mensuel_irl (
    p_numero_contrat IN SAE_ContratLocation.Numero_de_contrat%TYPE
) IS
    v_max_irl NUMBER;
    v_derniere_date DATE;
BEGIN


    SELECT Derniere_Date_Revalorisation
    INTO v_derniere_date
    FROM SAE_Revalorisation_Loyer
    WHERE fk_Numero_de_contrat = p_numero_contrat;
    IF ADD_MONTHS(TRUNC(v_derniere_date), 12) > TRUNC(SYSDATE) THEN
        RAISE_APPLICATION_ERROR(
            -20040,
            'Revalorisation impossible : moins d''un an depuis la derniere mise a jour'
        );
    END IF;




    v_max_irl := get_max_irl;
    UPDATE SAE_ContratLocation
    SET Montant_Mensuel = Montant_Mensuel * v_max_irl
    WHERE Numero_de_contrat = p_numero_contrat;
    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(
            -20030,
            'Aucun contrat trouve pour le numero : ' || p_numero_contrat
        );
    END IF;


    UPDATE SAE_Revalorisation_Loyer
    SET Derniere_Date_Revalorisation = TRUNC(SYSDATE),
        Loyer_Base = (
            SELECT Montant_Mensuel
            FROM SAE_ContratLocation
            WHERE Numero_de_contrat = p_numero_contrat
        )
    WHERE fk_Numero_de_contrat = p_numero_contrat;
    COMMIT;
END;
/



--Creer une date d anniversaire automatiquement quand on creer un contrat
CREATE OR REPLACE TRIGGER AnniversaireBaseContrat
AFTER INSERT ON SAE_CONTRATLOCATION
FOR EACH ROW
DECLARE

BEGIN
   INSERT INTO SAE_Revalorisation_Loyer 
   ( fk_Numero_de_contrat, Derniere_Date_Revalorisation, Loyer_Base)
    VALUES 
    (:NEW.Numero_de_contrat, :NEW.Date_debut, :NEW.Montant_Mensuel);
END;
/


-- A la suppression d'un bien louable, on modifie la date de fin du contrat
CREATE OR REPLACE TRIGGER ChangeFinContratSuppressionBien
AFTER DELETE ON SAE_Contrat_Locataire
FOR EACH ROW
BEGIN
   DELETE FROM SAE_ContratLocation cl
   WHERE cl.Numero_de_contrat = :OLD.Numero_de_contrat
     AND NOT EXISTS (
         SELECT 1
         FROM SAE_Contrat_Locataire clt
         WHERE clt.Numero_de_contrat = :OLD.Numero_de_contrat
     );
END;
/


CREATE OR REPLACE FUNCTION calcul_solde_tout_compte_locataire (
    p_id_locataire        IN VARCHAR2,
    p_montant_etat_lieux  IN NUMBER -- on demande le montant estimé de l'état des lieux car on ne le stocke pas dans la BD
) RETURN NUMBER
IS
    v_contrat          MSF5131A.SAE_ContratLocation.Numero_de_contrat%TYPE;
    v_loyer_mensuel    MSF5131A.SAE_ContratLocation.Montant_Mensuel%TYPE;
    v_caution          MSF5131A.SAE_ContratLocation.Montant_de_caution%TYPE;

    v_date_calcul      DATE := SYSDATE;
    v_debut_annee      DATE;
    v_fin_annee        DATE;

    v_charges          NUMBER := 0;
    v_total_paye       NUMBER := 0;
    v_loyers_impayes   NUMBER := 0;
    v_prorata          NUMBER := 0;
    v_nb_mois          NUMBER := 0;
BEGIN

    SELECT cl.Numero_de_contrat,
           cl.Montant_Mensuel,
           cl.Montant_de_caution
    INTO   v_contrat,
           v_loyer_mensuel,
           v_caution
    FROM   MSF5131A.SAE_ContratLocation cl,
           MSF5131A.SAE_Contrat_Locataire cll
    WHERE  cl.Numero_de_contrat = cll.Numero_de_contrat
      AND  cll.Id_Locataire = p_id_locataire;

    v_debut_annee := TRUNC(v_date_calcul, 'YYYY');
    v_fin_annee   := ADD_MONTHS(v_debut_annee, 12) - 1;

    v_charges := calcul_regularisation_contrat(
                     TO_NUMBER(TO_CHAR(v_date_calcul, 'YYYY')),
                     v_contrat
                 );

    SELECT NVL(SUM(p.Montant), 0)
    INTO   v_total_paye
    FROM   MSF5131A.SAE_Paiement p
    WHERE  p.fk_Numero_de_contrat = v_contrat
      AND  p.Date_Paiement BETWEEN v_debut_annee AND v_fin_annee;

    v_nb_mois :=
        MONTHS_BETWEEN(
            TRUNC(v_date_calcul, 'MM') + INTERVAL '1' MONTH,
            v_debut_annee
        );

    v_loyers_impayes :=
        (v_nb_mois * v_loyer_mensuel) - v_total_paye;

    -- Si le locataire a trop payé, on considère qu'il na pas d’impayés
    IF v_loyers_impayes < 0 THEN
        v_loyers_impayes := 0;
    END IF;

    v_prorata :=
        (v_loyer_mensuel
         / (LAST_DAY(v_date_calcul) - TRUNC(v_date_calcul, 'MM') + 1))
        * (v_date_calcul - TRUNC(v_date_calcul, 'MM') + 1);

    RETURN
          NVL(v_loyers_impayes, 0)
        + NVL(v_prorata, 0)
        + NVL(v_charges, 0)
        + NVL(p_montant_etat_lieux, 0)
        - NVL(v_caution, 0);

    -- > 0 : le locataire doit payer
    -- < 0 : le propri?taire rembourse

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;