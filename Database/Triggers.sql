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