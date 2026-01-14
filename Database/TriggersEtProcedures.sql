----Rajouter un trigger qui retire du solde quand on ajoute un paiement

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

    --Verifie la derniere date de lancement et mes a jour le solde en fonction des 
    --loyers et charges qui n etaient pas ajoute
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
        RETURN; -- rien ÃƒÂ  faire
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


EXECUTE VerifierDateLancement;
----TestTriggers
--INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat,Designation_Paiement)
--    VALUES ('PAY-040',900,TO_DATE('2024-03-01','YYYY-MM-DD'),'CTR-001','Charges');
--INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat,Designation_Paiement)
--    VALUES ('PAY-041',-900,TO_DATE('2024-03-01','YYYY-MM-DD'),'CTR-001','Charges');




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







    --Verifie la derniere date d anniversaire et si un an s est ecoule soustrait les provisions de charge en fonction des 
    --charges reeles puis l'ajoute au solde
    --a 1 ans ou + : solde = loyer + provision -(provision - charges reelles)
    --a tester avec provision a 200 et charges reelles 160 puis provision a 160 et charges reelles 200   

            
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
            'Revalorisation impossible : moins d''un an depuis la derniere mise Ã  jour'
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


CREATE OR REPLACE TRIGGER TRG_DEL_BIENLOUABLE_CASCADE
BEFORE DELETE ON SAE_BienLouable
FOR EACH ROW
BEGIN
    ------------------------------------------------------------------
    -- 1) Delete data linked to contracts of this Bien
    ------------------------------------------------------------------

    -- Date anniversaire
    DELETE FROM SAE_DateAnniversaireContrat
    WHERE fk_Numero_de_contrat IN (
        SELECT Numero_de_contrat
        FROM SAE_ContratLocation
        WHERE fk_Id_BienLouable = :OLD.Id_BienLouable
    );

    -- Revalorisation loyer
    DELETE FROM SAE_Revalorisation_Loyer
    WHERE fk_Numero_de_contrat IN (
        SELECT Numero_de_contrat
        FROM SAE_ContratLocation
        WHERE fk_Id_BienLouable = :OLD.Id_BienLouable
    );

    -- Paiements
    DELETE FROM SAE_Paiement
    WHERE fk_Numero_de_contrat IN (
        SELECT Numero_de_contrat
        FROM SAE_ContratLocation
        WHERE fk_Id_BienLouable = :OLD.Id_BienLouable
    );

    -- Locataire–Contrat links
    DELETE FROM SAE_Contrat_Locataire
    WHERE Numero_de_contrat IN (
        SELECT Numero_de_contrat
        FROM SAE_ContratLocation
        WHERE fk_Id_BienLouable = :OLD.Id_BienLouable
    );

    -- Contracts
    DELETE FROM SAE_ContratLocation
    WHERE fk_Id_BienLouable = :OLD.Id_BienLouable;

    ------------------------------------------------------------------
    -- 2) Delete direct children of BienLouable
    ------------------------------------------------------------------

    DELETE FROM SAE_Charges_Generale
    WHERE fk_Id_BienLouable = :OLD.Id_BienLouable;

    DELETE FROM SAE_Diagnostics
    WHERE fk_Id_BienLouable = :OLD.Id_BienLouable;

    DELETE FROM SAE_Compteur
    WHERE fk_Id_BienLouable = :OLD.Id_BienLouable;

    DELETE FROM SAE_Facture
    WHERE fk_Id_BienLouable = :OLD.Id_BienLouable;

END;
/