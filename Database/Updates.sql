UPDATE SAE_Paiement SET Designation_Paiement = 'Charges'
       WHERE Id_Paiement= 'PAY-014' 
       OR Id_Paiement='PAY-015'
       OR Id_Paiement='PAY-017'
       OR Id_Paiement='PAY-019'
       OR Id_Paiement='PAY-022'
       OR Id_Paiement='PAY-025'
       OR Id_Paiement='PAY-026'
       OR Id_Paiement='PAY-027'
       OR Id_Paiement='PAY-029'
       OR Id_Paiement='PAY-030'
       OR Id_Paiement='PAY-032'
       OR Id_Paiement='PAY-034'
       OR Id_Paiement='PAY-036'
       OR Id_Paiement='PAY-037'
       OR Id_Paiement='PAY-039'
       ;

UPDATE SAE_ContratLocation SET Solde = 0 - Montant_Mensuel;
UPDATE SAE_DateDernierLancement SET date_dernier_lancement = TO_DATE('2024-09-15','YYYY-MM-DD');


UPDATE SAE_Paiement SET Designation_Paiement = 'Loyer'
       WHERE Id_Paiement= 'PAY-016' 
       OR Id_Paiement='PAY-018'
       OR Id_Paiement='PAY-020'
       OR Id_Paiement='PAY-021'
       OR Id_Paiement='PAY-023'
       OR Id_Paiement='PAY-024'
       OR Id_Paiement='PAY-028'
       OR Id_Paiement='PAY-031'
       OR Id_Paiement='PAY-033'
       OR Id_Paiement='PAY-035'
       OR Id_Paiement='PAY-038'
       ;


UPDATE SAE_Facture SET Designation_de_travaux = 'Reparation plomberie'
       WHERE Numero_Facture = 'FAC-001'; 



UPDATE SAE_Facture SET Designation_de_travaux = 'Reparation electrique'
       WHERE Numero_Facture = 'FAC-002'; 
UPDATE SAE_Facture SET Designation_de_travaux = 'Renovation cuisine'
       WHERE Numero_Facture = 'FAC-003'; 
UPDATE SAE_Facture SET Designation_de_travaux = 'Remplacement chaudiere'
       WHERE Numero_Facture = 'FAC-004'; 
UPDATE SAE_Facture SET Designation_de_travaux = 'Reparation clim'
       WHERE Numero_Facture = 'FAC-005'; 
UPDATE SAE_Facture SET Designation_de_travaux = 'Travaux peinture'
       WHERE Numero_Facture = 'FAC-006'; 
UPDATE SAE_Facture SET Designation_de_travaux = 'Depannage fuite sous evier'
       WHERE Numero_Facture = 'FAC-007'; 
UPDATE SAE_Facture SET Designation_de_travaux = 'Remplacement colonne d evacuation'
       WHERE Numero_Facture = 'FAC-008'; 
UPDATE SAE_Facture SET Designation_de_travaux = 'Remplacement disjoncteur'
       WHERE Numero_Facture = 'FAC-009';
UPDATE SAE_Facture SET Designation_de_travaux = 'Mise aux normes tableau electrique'
       WHERE Numero_Facture = 'FAC-010'; 
UPDATE SAE_Facture SET Designation_de_travaux = 'Renovation salle de bains'
       WHERE Numero_Facture = 'FAC-011'; 
UPDATE SAE_Facture SET Designation_de_travaux = 'Travaux de menuiserie interieure'
       WHERE Numero_Facture = 'FAC-012'; 
UPDATE SAE_Facture SET Designation_de_travaux = 'Revision annuelle chaudiere'
       WHERE Numero_Facture = 'FAC-013'; 
UPDATE SAE_Facture SET Designation_de_travaux = 'Installation radiateurs thermostatiques'
       WHERE Numero_Facture = 'FAC-014'; 
UPDATE SAE_Facture SET Designation_de_travaux = 'Recharge gaz clim'
       WHERE Numero_Facture = 'FAC-015'; 
UPDATE SAE_Facture SET Designation_de_travaux = 'Installation clim split'
       WHERE Numero_Facture = 'FAC-016'; 
UPDATE SAE_Facture SET Designation_de_travaux = 'Peinture chambre et salon'
       WHERE Numero_Facture = 'FAC-017'; 
UPDATE SAE_Facture SET Designation_de_travaux = 'Rafraichissement complet appartement'
       WHERE Numero_Facture = 'FAC-018'; 

UPDATE SAE_DIAGNOSTICS SET Fichier = 'Diagnostics/Diagnostics.pdf';

UPDATE SAE_ContratLocation Set Solde = 0 WHERE numero_de_contrat = 'CTR-0015';
UPDATE SAE_DateAnniversaireContrat SET Date_dernier_anniversaire = TO_DATE('2023-03-17','YYYY-MM-DD')
       WHERE fk_Numero_de_contrat = 'CTR-0015'; 