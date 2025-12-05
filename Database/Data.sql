
INSERT INTO SAE_Garant (Id_Garant,Prenom,Nom, Adresse, Tel) VALUES ('GAR-001', 'Martin', 'Dupont', '12 Rue des Lys', '0601020304');
INSERT INTO SAE_Garant (Id_Garant,Prenom,Nom, Adresse, Tel) VALUES ('GAR-002', 'Claire', 'Renaud', '8 Avenue Victor Hugo', '0605060708');
INSERT INTO SAE_Garant (Id_Garant,Prenom,Nom, Adresse, Tel) VALUES ('GAR-003', 'Pierre', 'Lamart', '5 Rue du Marché', '0611223344');
INSERT INTO SAE_Garant (Id_Garant,Prenom,Nom, Adresse, Tel) VALUES ('GAR-004', 'Sophie', 'Armand', '22 Rue de la Paix', '0677889900');
INSERT INTO SAE_Garant (Id_Garant,Prenom,Nom, Adresse, Tel) VALUES ('GAR-005', 'Nicolas', 'Breton', '14 Boulevard Carnot', '0644556677');
INSERT INTO SAE_Garant (Id_Garant,Prenom,Nom, Adresse, Tel) VALUES ('GAR-006', 'Lucie', 'Morel', '3 Rue Antoine Lumière', '0622334455');


----------------------------------------------------------------------------------------------------------------


INSERT INTO SAE_Batiment (Adresse, Date_construction) VALUES ('BAT-001', TO_DATE('2001-05-12','YYYY-MM-DD'));
INSERT INTO SAE_Batiment (Adresse, Date_construction) VALUES ('BAT-002', TO_DATE('1998-11-03','YYYY-MM-DD'));
INSERT INTO SAE_Batiment (Adresse, Date_construction) VALUES ('BAT-003', TO_DATE('2010-02-17','YYYY-MM-DD'));
INSERT INTO SAE_Batiment (Adresse, Date_construction) VALUES ('BAT-004', TO_DATE('1985-08-29','YYYY-MM-DD'));
INSERT INTO SAE_Batiment (Adresse, Date_construction) VALUES ('BAT-005', TO_DATE('2005-04-14','YYYY-MM-DD'));
INSERT INTO SAE_Batiment (Adresse, Date_construction) VALUES ('BAT-006', TO_DATE('1992-12-01','YYYY-MM-DD'));


----------------------------------------------------------------------------------------------------------------

INSERT INTO SAE_BienLouable (Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
 VALUES ('BIEN-001','FISC-001','12 Rue des Roses',65,3,'Appartement',NULL,'BAT-001');
INSERT INTO SAE_BienLouable (Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
 VALUES ('BIEN-002','FISC-002','8 Rue des Lilas',42,2,'Studio',NULL,'BAT-001');
INSERT INTO SAE_BienLouable (Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
 VALUES ('BIEN-003','FISC-003','4 Rue du Port',110,5,'Maison',NULL,'BAT-003');
INSERT INTO SAE_BienLouable (Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
 VALUES ('BIEN-004','FISC-004','10 Rue Nationale',75,3,'Appartement',NULL,'BAT-004');
INSERT INTO SAE_BienLouable (Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
 VALUES ('BIEN-005','FISC-005','18 Avenue du Parc',30,1,'Studio',NULL,'BAT-005');
INSERT INTO SAE_BienLouable (Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
 VALUES ('BIEN-006','FISC-006','33 Rue des Écoles',95,4,'Appartement',NULL,'BAT-006');


----------------------------------------------------------------------------------------------------------------





INSERT INTO SAE_Locataire (Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, 
 Lieu_de_naissance, Salaire, Profession, Situation_Familiale, Image_Locataire, fk_Id_Garant)
VALUES ('LOC-001','Durand','Alice','12 Rue des Lys','0600000001','alice@mail.com','75001','Paris',
        TO_DATE('1994-03-12','YYYY-MM-DD'),'Paris',2100,'Ingénieur','Célibataire',NULL,'GAR-001');

INSERT INTO SAE_Locataire (Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, 
 Lieu_de_naissance, Salaire, Profession, Situation_Familiale, Image_Locataire, fk_Id_Garant)
VALUES ('LOC-002','Bernard','Thomas','4 Rue du Port','0600000002','thomas@mail.com','75002','Paris',
        TO_DATE('1988-07-23','YYYY-MM-DD'),'Lyon',1800,'Technicien','Marié',NULL,'GAR-002');

INSERT INTO SAE_Locataire (Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, 
 Lieu_de_naissance, Salaire, Profession, Situation_Familiale, Image_Locataire, fk_Id_Garant)
VALUES ('LOC-003','Petit','Laura','10 Rue Nationale','0600000003','laura@mail.com','69001','Lyon',
        TO_DATE('1996-05-10','YYYY-MM-DD'),'Marseille',2500,'Développeuse','Célibataire',NULL,'GAR-003');

INSERT INTO SAE_Locataire (Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, 
 Lieu_de_naissance, Salaire, Profession, Situation_Familiale, Image_Locataire, fk_Id_Garant)
VALUES ('LOC-004','Rossi','Marco','18 Avenue du Parc','0600000004','marco@mail.com','59000','Lille',
        TO_DATE('1984-12-18','YYYY-MM-DD'),'Rouen',1600,'Serveur','Divorcé',NULL,'GAR-004');

INSERT INTO SAE_Locataire (Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, 
 Lieu_de_naissance, Salaire, Profession, Situation_Familiale, Image_Locataire, fk_Id_Garant)
VALUES ('LOC-005','Lemoine','Sarah','33 Rue des Écoles','0600000005','sarah@mail.com','33000','Bordeaux',
        TO_DATE('1992-01-05','YYYY-MM-DD'),'Bordeaux',2000,'Infirmière','Célibataire',NULL,'GAR-005');

INSERT INTO SAE_Locataire (Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, 
 Lieu_de_naissance, Salaire, Profession, Situation_Familiale, Image_Locataire, fk_Id_Garant)
VALUES ('LOC-006','Robert','Julien','4 Rue des Lilas','0600000006','julien@mail.com','31000','Toulouse',
        TO_DATE('1990-09-09','YYYY-MM-DD'),'Toulouse',2300,'Professeur','Marié',NULL,'GAR-006');

----------------------------------------------------------------------------------------------------------------






INSERT INTO SAE_ContratLocation (Numero_de_contrat,Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel,
 Date_versement, Index_Compteur_Eau, Index_Compteur_Electrcite, Index_Compteur_Gaz, fk_Id_BienLouable)
 VALUES ('CTR-001',TO_DATE('2023-01-01','YYYY-MM-DD'),NULL,800,40,0,900,NULL,0,0,0,'BIEN-001');

INSERT INTO SAE_ContratLocation (Numero_de_contrat,Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel,
 Date_versement, Index_Compteur_Eau, Index_Compteur_Electrcite, Index_Compteur_Gaz, fk_Id_BienLouable)
 VALUES ('CTR-002',TO_DATE('2023-02-15','YYYY-MM-DD'),NULL,600,30,0,750,NULL,0,0,0,'BIEN-002');

INSERT INTO SAE_ContratLocation (Numero_de_contrat,Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel,
 Date_versement, Index_Compteur_Eau, Index_Compteur_Electrcite, Index_Compteur_Gaz, fk_Id_BienLouable)
 VALUES ('CTR-003',TO_DATE('2022-10-01','YYYY-MM-DD'),NULL,1200,50,0,1100,NULL,0,0,0,'BIEN-003');

INSERT INTO SAE_ContratLocation (Numero_de_contrat,Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel,
 Date_versement, Index_Compteur_Eau, Index_Compteur_Electrcite, Index_Compteur_Gaz, fk_Id_BienLouable)
 VALUES ('CTR-004',TO_DATE('2023-03-20','YYYY-MM-DD'),NULL,900,40,0,950,NULL,0,0,0,'BIEN-004');

INSERT INTO SAE_ContratLocation (Numero_de_contrat,Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel,
 Date_versement, Index_Compteur_Eau, Index_Compteur_Electrcite, Index_Compteur_Gaz, fk_Id_BienLouable)
 VALUES ('CTR-005',TO_DATE('2023-05-01','YYYY-MM-DD'),NULL,500,20,0,700,NULL,0,0,0,'BIEN-005');

INSERT INTO SAE_ContratLocation (Numero_de_contrat,Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel,
 Date_versement, Index_Compteur_Eau, Index_Compteur_Electrcite, Index_Compteur_Gaz, fk_Id_BienLouable)
 VALUES ('CTR-006',TO_DATE('2022-09-10','YYYY-MM-DD'),NULL,1000,35,0,1050,NULL,0,0,0,'BIEN-006');
----------------------------------------------------------------------------------------------------------------


INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Mois, fk_Id_BienLouable)
 VALUES ('CHG-001','Entretien',80,10,1.0,'JANVIER','BIEN-001');
 
INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Mois, fk_Id_BienLouable)
 VALUES ('CHG-002','Nettoyage',120,15,1.1,'FEVRIER','BIEN-002');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Mois, fk_Id_BienLouable) 
 VALUES ('CHG-003','Nettoyage',200,20,1.2,'AVRIL','BIEN-003');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Mois, fk_Id_BienLouable) 
 VALUES ('CHG-004','Entretien',60,8,0.8,'DECEMBRE','BIEN-004');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Mois, fk_Id_BienLouable)
 VALUES ('CHG-005','Ascenseur',90,12,0.9,'AOUT','BIEN-005');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Mois, fk_Id_BienLouable)
VALUES ('CHG-006','Nettoyage',70,10,1.0,'MARS','BIEN-006');

----------------------------------------------------------------------------------------------------------------





INSERT INTO SAE_Diagnostics (Id_Diagnostics, Type_Diagnostic, Date_Realisation, Date_Validite, Fichier, fk_Id_BienLouable)
 VALUES ('DIA-001','DPE',TO_DATE('2022-09-01','YYYY-MM-DD'),TO_DATE('2032-09-01','YYYY-MM-DD'),'dpe1.pdf','BIEN-001');

INSERT INTO SAE_Diagnostics (Id_Diagnostics, Type_Diagnostic, Date_Realisation, Date_Validite, Fichier, fk_Id_BienLouable)
 VALUES ('DIA-002','Gaz',TO_DATE('2022-10-05','YYYY-MM-DD'),TO_DATE('2032-10-05','YYYY-MM-DD'),'gaz2.pdf','BIEN-002');

INSERT INTO SAE_Diagnostics (Id_Diagnostics, Type_Diagnostic, Date_Realisation, Date_Validite, Fichier, fk_Id_BienLouable)
 VALUES ('DIA-003','Électricité',TO_DATE('2023-01-10','YYYY-MM-DD'),TO_DATE('2033-01-10','YYYY-MM-DD'),'elec3.pdf','BIEN-003');

INSERT INTO SAE_Diagnostics (Id_Diagnostics, Type_Diagnostic, Date_Realisation, Date_Validite, Fichier, fk_Id_BienLouable)
 VALUES ('DIA-004','Amiante',TO_DATE('2021-06-15','YYYY-MM-DD'),TO_DATE('2031-06-15','YYYY-MM-DD'),'ami4.pdf','BIEN-004');

INSERT INTO SAE_Diagnostics (Id_Diagnostics, Type_Diagnostic, Date_Realisation, Date_Validite, Fichier, fk_Id_BienLouable)
 VALUES ('DIA-005','Plomb',TO_DATE('2020-11-01','YYYY-MM-DD'),TO_DATE('2030-11-01','YYYY-MM-DD'),'plomb5.pdf','BIEN-005');

INSERT INTO SAE_Diagnostics (Id_Diagnostics, Type_Diagnostic, Date_Realisation, Date_Validite, Fichier, fk_Id_BienLouable) 
 VALUES ('DIA-006','Termites',TO_DATE('2023-02-20','YYYY-MM-DD'),TO_DATE('2028-02-20','YYYY-MM-DD'),'term6.pdf','BIEN-006');
----------------------------------------------------------------------------------------------------------------




INSERT INTO SAE_IRL (Annee, IRL) VALUES (2020,130.5);
INSERT INTO SAE_IRL (Annee, IRL) VALUES (2021,132.2);
INSERT INTO SAE_IRL (Annee, IRL) VALUES (2022,135.6);
INSERT INTO SAE_IRL (Annee, IRL) VALUES (2023,138.5);
INSERT INTO SAE_IRL (Annee, IRL) VALUES (2019,128.4);
INSERT INTO SAE_IRL (Annee, IRL) VALUES (2018,126.3);

----------------------------------------------------------------------------------------------------------------

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-001',900,TO_DATE('2023-02-01','YYYY-MM-DD'),'CTR-001');
INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-002',750,TO_DATE('2023-03-01','YYYY-MM-DD'),'CTR-002');
INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-003',1100,TO_DATE('2023-01-01','YYYY-MM-DD'),'CTR-003');
INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-004',950,TO_DATE('2023-04-05','YYYY-MM-DD'),'CTR-004');
INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-005',700,TO_DATE('2023-06-01','YYYY-MM-DD'),'CTR-005');
INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-006',1050,TO_DATE('2023-10-01','YYYY-MM-DD'),'CTR-006');

----------------------------------------------------------------------------------------------------------------






INSERT INTO SAE_Assurance (Numero_d_assurance, Prime, Montant, Type_assurance, Agence, Adresse_agence, Tel_agence, fk_Adresse)
 VALUES ('ASS-001',200,120,'Habitation','AXA','12 Rue Blanche','0145002001','BAT-001');

INSERT INTO SAE_Assurance (Numero_d_assurance, Prime, Montant, Type_assurance, Agence, Adresse_agence, Tel_agence, fk_Adresse)
 VALUES ('ASS-002',250,140,'Locataire','MAIF','8 Rue des Arts','0145203001','BAT-002');

INSERT INTO SAE_Assurance (Numero_d_assurance, Prime, Montant, Type_assurance, Agence, Adresse_agence, Tel_agence, fk_Adresse)
 VALUES ('ASS-003',300,160,'Propriétaire','Groupama','5 Rue du Moulin','0145304001','BAT-003');

INSERT INTO SAE_Assurance (Numero_d_assurance, Prime, Montant, Type_assurance, Agence, Adresse_agence, Tel_agence, fk_Adresse)
 VALUES ('ASS-004',180,100,'Incendie','Allianz','3 Rue Verte','0145506001','BAT-004');

INSERT INTO SAE_Assurance (Numero_d_assurance, Prime, Montant, Type_assurance, Agence, Adresse_agence, Tel_agence, fk_Adresse)
 VALUES ('ASS-005',220,130,'Multirisque','AXA','15 Avenue Est','0145607001','BAT-005'); 

INSERT INTO SAE_Assurance (Numero_d_assurance, Prime, Montant, Type_assurance, Agence, Adresse_agence, Tel_agence, fk_Adresse)
 VALUES ('ASS-006',240,150,'Habitation','MAIF','9 Rue Royale','0145708001','BAT-006');

----------------------------------------------------------------------------------------------------------------


INSERT INTO SAE_Compteur (Id_Compteur,Partie_Fixe, Partie_Variable, Total, TypeCompteur, Date_Installation,
 Index_ancien, Index_nouveau, fk_Id_BienLouable)
 VALUES ('COMP-001',30,12,42,'Eau',TO_DATE('2019-01-01','YYYY-MM-DD'),100,120,'BIEN-001');
 INSERT INTO SAE_Compteur VALUES ('COMP-014',48,22,70,'Électricité',TO_DATE('2018-05-15','YYYY-MM-DD'),125,150,'BIEN-001');
INSERT INTO SAE_Compteur VALUES ('COMP-015',33,18,51,'Gaz',TO_DATE('2019-02-11','YYYY-MM-DD'),510,545,'BIEN-001');

INSERT INTO SAE_Compteur (Id_Compteur,Partie_Fixe, Partie_Variable, Total, TypeCompteur, Date_Installation,
 Index_ancien, Index_nouveau, fk_Id_BienLouable)
 VALUES ('COMP-002',40,18,58,'Électricité',TO_DATE('2020-05-12','YYYY-MM-DD'),2300,2350,'BIEN-002');
INSERT INTO SAE_Compteur VALUES ('COMP-016',28,9,37,'Eau',TO_DATE('2017-07-01','YYYY-MM-DD'),300,320,'BIEN-002');
INSERT INTO SAE_Compteur VALUES ('COMP-017',30,12,42,'Gaz',TO_DATE('2019-10-22','YYYY-MM-DD'),560,600,'BIEN-002');

INSERT INTO SAE_Compteur (Id_Compteur,Partie_Fixe, Partie_Variable, Total, TypeCompteur, Date_Installation,
 Index_ancien, Index_nouveau, fk_Id_BienLouable)
 VALUES ('COMP-003',35,20,55,'Gaz',TO_DATE('2018-08-08','YYYY-MM-DD'),500,540,'BIEN-003');
 INSERT INTO SAE_Compteur VALUES ('COMP-018',40,16,56,'Eau',TO_DATE('2018-05-09','YYYY-MM-DD'),350,380,'BIEN-003');
INSERT INTO SAE_Compteur VALUES ('COMP-019',55,25,80,'Électricité',TO_DATE('2020-01-15','YYYY-MM-DD'),1800,1850,'BIEN-003');

INSERT INTO SAE_Compteur (Id_Compteur,Partie_Fixe, Partie_Variable, Total, TypeCompteur, Date_Installation,
 Index_ancien, Index_nouveau, fk_Id_BienLouable)
 VALUES ('COMP-004',45,15,60,'Eau',TO_DATE('2021-02-02','YYYY-MM-DD'),300,320,'BIEN-004');
 INSERT INTO SAE_Compteur VALUES ('COMP-020',47,21,68,'Électricité',TO_DATE('2021-04-04','YYYY-MM-DD'),390,430,'BIEN-004');
INSERT INTO SAE_Compteur VALUES ('COMP-021',32,14,46,'Gaz',TO_DATE('2022-06-06','YYYY-MM-DD'),600,650,'BIEN-004');

INSERT INTO SAE_Compteur (Id_Compteur,Partie_Fixe, Partie_Variable, Total, TypeCompteur, Date_Installation,
 Index_ancien, Index_nouveau, fk_Id_BienLouable)
 VALUES ('COMP-005',50,25,75,'Électricité',TO_DATE('2020-09-17','YYYY-MM-DD'),800,850,'BIEN-005');
 INSERT INTO SAE_Compteur VALUES ('COMP-022',18,7,25,'Eau',TO_DATE('2020-11-10','YYYY-MM-DD'),135,150,'BIEN-005');
INSERT INTO SAE_Compteur VALUES ('COMP-023',27,11,38,'Gaz',TO_DATE('2021-09-14','YYYY-MM-DD'),480,520,'BIEN-005');

INSERT INTO SAE_Compteur (Id_Compteur,Partie_Fixe, Partie_Variable, Total, TypeCompteur, Date_Installation,
 Index_ancien, Index_nouveau, fk_Id_BienLouable)
 VALUES ('COMP-006',38,17,55,'Gaz',TO_DATE('2022-03-10','YYYY-MM-DD'),1000,1060,'BIEN-006');
 INSERT INTO SAE_Compteur VALUES ('COMP-024',36,15,51,'Eau',TO_DATE('2018-02-15','YYYY-MM-DD'),250,280,'BIEN-006');
INSERT INTO SAE_Compteur VALUES ('COMP-025',52,26,78,'Électricité',TO_DATE('2021-03-03','YYYY-MM-DD'),900,950,'BIEN-006');

----------------------------------------------------------------------------------------------------------------

INSERT INTO SAE_Entreprise 
(Numero_Siret, Adresse, Ville, Code_Postale, Nom, Numero_de_Telephone, Specialite)
VALUES ('SIRET001', '15 Rue Tech', 'Paris', '75002', 'TechFix', '0140001122', 'Plomberie');

INSERT INTO SAE_Entreprise 
(Numero_Siret, Adresse, Ville, Code_Postale, Nom, Numero_de_Telephone, Specialite)
VALUES ('SIRET002', '8 Avenue Pro', 'Lyon', '69003', 'ProElec', '0472004455', '�lectricit�');

INSERT INTO SAE_Entreprise 
(Numero_Siret, Adresse, Ville, Code_Postale, Nom, Numero_de_Telephone, Specialite)
VALUES ('SIRET003', '12 Rue des Roses', 'Marseille', '13005', 'RenoCuisinePro', '0102030407', 'R�novation');

INSERT INTO SAE_Entreprise 
(Numero_Siret, Adresse, Ville, Code_Postale, Nom, Numero_de_Telephone, Specialite)
VALUES ('SIRET004', '10 Rue Nationale', 'Lille', '59000', 'ChaudieresCom', '0102030408', 'Chauffage');

INSERT INTO SAE_Entreprise 
(Numero_Siret, Adresse, Ville, Code_Postale, Nom, Numero_de_Telephone, Specialite)
VALUES ('SIRET005', '18 Avenue du Parc', 'Toulouse', '31000', 'ClimServices', '0102030409', 'Climatisation');

INSERT INTO SAE_Entreprise 
(Numero_Siret, Adresse, Ville, Code_Postale, Nom, Numero_de_Telephone, Specialite)
VALUES ('SIRET006', '33 Rue des �coles', 'Nice', '06000', 'PeintureDesign', '0102030410', 'Peinture');

----------------------------------------------------------------------------------------------------------------


INSERT INTO SAE_Facture (Numero_Facture, Montant, Date_de_facture, Compte_Bancaire, Montant_Devis, Date_Paiement, 
 Designation_de_travaux, fk_Id_BienLouable, fk_Numero_Siret)
 VALUES ('FAC-001',350,TO_DATE('2023-03-01','YYYY-MM-DD'),'FR761234567890',300,TO_DATE('2023-03-10','YYYY-MM-DD'),'Réparation plomberie','BIEN-001','SIRET001');

INSERT INTO SAE_Facture (Numero_Facture, Montant, Date_de_facture, Compte_Bancaire, Montant_Devis, Date_Paiement, 
 Designation_de_travaux, fk_Id_BienLouable, fk_Numero_Siret)
 VALUES ('FAC-002',450,TO_DATE('2023-04-01','YYYY-MM-DD'),'FR098765432100',400,TO_DATE('2023-04-12','YYYY-MM-DD'),'Réparation électrique','BIEN-002','SIRET002');

INSERT INTO SAE_Facture (Numero_Facture, Montant, Date_de_facture, Compte_Bancaire, Montant_Devis, Date_Paiement, 
 Designation_de_travaux, fk_Id_BienLouable, fk_Numero_Siret)
 VALUES ('FAC-003',1500,TO_DATE('2023-06-01','YYYY-MM-DD'),'FR230045678901',1450,TO_DATE('2023-06-15','YYYY-MM-DD'),'Rénovation cuisine','BIEN-003','SIRET003');

INSERT INTO SAE_Facture (Numero_Facture, Montant, Date_de_facture, Compte_Bancaire, Montant_Devis, Date_Paiement, 
 Designation_de_travaux, fk_Id_BienLouable, fk_Numero_Siret)
 VALUES ('FAC-004',780,TO_DATE('2023-02-18','YYYY-MM-DD'),'FR560123980001',760,TO_DATE('2023-02-25','YYYY-MM-DD'),'Remplacement chaudière','BIEN-004','SIRET004');

INSERT INTO SAE_Facture (Numero_Facture, Montant, Date_de_facture, Compte_Bancaire, Montant_Devis, Date_Paiement, 
 Designation_de_travaux, fk_Id_BienLouable, fk_Numero_Siret)
 VALUES ('FAC-005',220,TO_DATE('2023-01-14','YYYY-MM-DD'),'FR670098123456',210,TO_DATE('2023-01-20','YYYY-MM-DD'),'Réparation clim','BIEN-005','SIRET005');

INSERT INTO SAE_Facture (Numero_Facture, Montant, Date_de_facture, Compte_Bancaire, Montant_Devis, Date_Paiement, 
 Designation_de_travaux, fk_Id_BienLouable, fk_Numero_Siret)
 VALUES ('FAC-006',950,TO_DATE('2023-05-22','YYYY-MM-DD'),'FR210067009988',900,TO_DATE('2023-05-29','YYYY-MM-DD'),'Travaux peinture','BIEN-006','SIRET006');


----------------------------------------------------------------------------------------------------------------




INSERT INTO SAE_Contrat_Locataire (Id_Locataire, Numero_de_contrat)
 VALUES ('LOC-001','CTR-001');

INSERT INTO SAE_Contrat_Locataire (Id_Locataire, Numero_de_contrat)
 VALUES ('LOC-002','CTR-002');

INSERT INTO SAE_Contrat_Locataire (Id_Locataire, Numero_de_contrat)
 VALUES ('LOC-003','CTR-003');

INSERT INTO SAE_Contrat_Locataire (Id_Locataire, Numero_de_contrat)
 VALUES ('LOC-004','CTR-004');

INSERT INTO SAE_Contrat_Locataire (Id_Locataire, Numero_de_contrat)
 VALUES ('LOC-005','CTR-005');

INSERT INTO SAE_Contrat_Locataire (Id_Locataire, Numero_de_contrat)
 VALUES ('LOC-006','CTR-006');