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
BEGIN

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
BEGIN

    --dac = Date Anniversaire Contrat
    --cl = Contrat Location
    FOR i IN (
        SELECT dac.fk_Numero_de_contrat,
               TRUNC(dac.Date_dernier_anniversaire, 'MM') AS date_anniv,
               cl.Provision_Charge,
               cl.fk_Id_BienLouable
        FROM SAE_DateAnniversaireContrat dac
        JOIN SAE_ContratLocation cl
             ON cl.Numero_de_contrat = dac.fk_Numero_de_contrat
    ) LOOP

        v_date := i.date_anniv;

        v_annees := FLOOR(
            MONTHS_BETWEEN(TRUNC(SYSDATE, 'MM'), v_date) / 12
        );

        IF v_annees >= 1 THEN

            SELECT NVL(SUM(Montant_Total), 0)
            INTO v_total_charges
            FROM SAE_Charges_Generale
            WHERE fk_Id_BienLouable = i.fk_Id_BienLouable;

            UPDATE SAE_ContratLocation
            SET Solde = Solde - ((i.Provision_Charge - v_total_charges) * 12 * v_annees)
            WHERE Numero_de_contrat = i.fk_Numero_de_contrat;

            v_date := ADD_MONTHS(v_date, v_annees * 12);

            UPDATE SAE_DateAnniversaireContrat
            SET Date_dernier_anniversaire = v_date
            WHERE fk_Numero_de_contrat = i.fk_Numero_de_contrat;
        END IF;

    END LOOP;

    COMMIT;
END VerifierDateAnniversaire;
/
