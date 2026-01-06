----Rajouter un trigger qui retire du solde quand on ajoute un paiement

CREATE OR REPLACE TRIGGER AjoutPaiementSolde
AFTER INSERT  ON
SAE_Paiement
--FOR EACH ROW
[When condition ]
[DECLARE]
-- declaration de variables, exceptions,
-- curseurs
BEGIN
-- bloc action-- ordres SQL et PL/SQL
END;/



--loyer  + provisions charges : 750
--solde : 0

--solde -750

--paiment : 650

--solde -100

