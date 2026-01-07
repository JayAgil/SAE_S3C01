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
    v_date   DATE;
    v_annees NUMBER;
    v_mois   NUMBER;
BEGIN
    -- Récupérer la date du dernier lancement (mois civil)
    SELECT TRUNC(date_dernier_lancement,'MM')
    INTO v_date
    FROM SAE_DateDernierLancement
    WHERE Id_Lock = 'X';

    -- Calcul des années complètes écoulées
    v_annees := FLOOR(MONTHS_BETWEEN(TRUNC(SYSDATE,'MM'), v_date) / 12);

    IF v_annees > 0 THEN
        -- Mise à jour du solde pour toutes les années
        UPDATE SAE_ContratLocation
        SET Solde = Solde - (Montant_Mensuel * v_annees * 12);

        -- Avancer la date d'autant d'années
        v_date := ADD_MONTHS(v_date, v_annees * 12);
    END IF;

    -- Calcul des mois restants après les années
    v_mois := MONTHS_BETWEEN(TRUNC(SYSDATE,'MM'), v_date);

    IF v_mois > 0 THEN
        -- Mise à jour du solde pour les mois restants
        UPDATE SAE_ContratLocation
        SET Solde = Solde - (Montant_Mensuel * v_mois);

        -- Avancer la date d'autant de mois
        v_date := ADD_MONTHS(v_date, v_mois);
    END IF;

    -- Mettre à jour la date dernier lancement
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




--loyer  + provisions charges : 750
--solde : 0

--solde -750

--paiment : 650

--solde -100


--dans bd rajouter une table qui contient la derniere date de lancement de l'appli
--au lancement de l'appli : check le mois actuel et le mois de la derniere date

--boucle
    --tant que annee_mois_bd =< annee_mois_actuel, solde += loyer mensuel
    --annee_mois_bd = annee_mois_bd+1
--fin boucle
--update date