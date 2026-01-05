
INSERT INTO SAE_Garant (Id_Garant,Prenom,Nom, Adresse, Tel) VALUES ('GAR-001', 'Martin', 'Dupont', '12 Rue des Lys', '0693765432');
INSERT INTO SAE_Garant (Id_Garant,Prenom,Nom, Adresse, Tel) VALUES ('GAR-002', 'Claire', 'Renaud', '8 Avenue Victor Hugo', '0692654322');
INSERT INTO SAE_Garant (Id_Garant,Prenom,Nom, Adresse, Tel) VALUES ('GAR-003', 'Pierre', 'Lamart', '5 Rue du Marché', '0693557204');
INSERT INTO SAE_Garant (Id_Garant,Prenom,Nom, Adresse, Tel) VALUES ('GAR-004', 'Sophie', 'Armand', '22 Rue de la Paix', '0677889900');
INSERT INTO SAE_Garant (Id_Garant,Prenom,Nom, Adresse, Tel) VALUES ('GAR-005', 'Nicolas', 'Breton', '14 Boulevard Carnot', '0644556677');
INSERT INTO SAE_Garant (Id_Garant,Prenom,Nom, Adresse, Tel) VALUES ('GAR-006', 'Lucie', 'Morel', '3 Rue Antoine Lumiere', '0622334455');
INSERT INTO SAE_Garant (Id_Garant,Prenom,Nom, Adresse, Tel) VALUES ('GAR-007', 'Hugo', 'Leclerc', '20 Rue des Marguerites', '0612345678');
INSERT INTO SAE_Garant (Id_Garant,Prenom,Nom, Adresse, Tel) VALUES ('GAR-008', 'Emma', 'Garnier', '7 Rue des Peupliers', '0655443322');
INSERT INTO SAE_Garant (Id_Garant,Prenom,Nom, Adresse, Tel) VALUES ('GAR-009', 'Julien', 'Perrot', '9 Impasse des Cedres', '0609090909');
INSERT INTO SAE_Garant (Id_Garant,Prenom,Nom, Adresse, Tel) VALUES ('GAR-010', 'Camille', 'Ruiz', '25 Rue du Stade', '0677001122');
INSERT INTO SAE_Garant (Id_Garant,Prenom,Nom, Adresse, Tel) VALUES ('GAR-011', 'Thomas', 'Bailly', '18 Rue de Seze', '0633221100');
INSERT INTO SAE_Garant (Id_Garant,Prenom,Nom, Adresse, Tel) VALUES ('GAR-012', 'Anaïs', 'Delorme', '11 Avenue des Acacias', '0699887766');
INSERT INTO SAE_Garant (Id_Garant,Prenom,Nom, Adresse, Tel) VALUES ('GAR-013', 'Romain', 'Georges', '42 Boulevard Voltaire', '0655332211');























----------------------------------------------------------------------------------------------------------------


INSERT INTO SAE_Batiment (Adresse, Date_construction) VALUES ('20 Chemin La Fayette', TO_DATE('2001-05-12','YYYY-MM-DD'));
INSERT INTO SAE_Batiment (Adresse, Date_construction) VALUES ('31 Rue de la Paix', TO_DATE('1998-11-03','YYYY-MM-DD'));
INSERT INTO SAE_Batiment (Adresse, Date_construction) VALUES ('15 Allee de la Gare', TO_DATE('2010-02-17','YYYY-MM-DD'));
INSERT INTO SAE_Batiment (Adresse, Date_construction) VALUES ('7 Rue de la Croix', TO_DATE('1985-08-29','YYYY-MM-DD'));
INSERT INTO SAE_Batiment (Adresse, Date_construction) VALUES ('24 Impasse des tomates', TO_DATE('2005-04-14','YYYY-MM-DD'));
INSERT INTO SAE_Batiment (Adresse, Date_construction) VALUES ('26 Chemin des pissenlits', TO_DATE('1992-12-01','YYYY-MM-DD'));
























----------------------------------------------------------------------------------------------------------------




INSERT INTO SAE_BienLouable(Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
  VALUES ('BIEN-008','FISC-008','07',48,2,'garage',NULL,'20 Chemin La Fayette');
 
INSERT INTO SAE_BienLouable (Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
 VALUES ('BIEN-001','FISC-001','17',65,3,'logement','BIEN-008','20 Chemin La Fayette');

INSERT INTO SAE_BienLouable (Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
 VALUES ('BIEN-007','FISC-007','26',55,2,'logement',NULL,'20 Chemin La Fayette');





INSERT INTO SAE_BienLouable (Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
VALUES ('BIEN-002','FISC-002','18',42,2,'garage',NULL,'31 Rue de la Paix');

INSERT INTO SAE_BienLouable(Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
  VALUES ('BIEN-009','FISC-009','21',70,3,'logement','BIEN-002','31 Rue de la Paix');

INSERT INTO SAE_BienLouable(Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
  VALUES ('BIEN-010','FISC-010','22',45,2,'garage',NULL,'31 Rue de la Paix');

INSERT INTO SAE_BienLouable(Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
  VALUES ('BIEN-011','FISC-011','06',60,3,'logement','BIEN-010','31 Rue de la Paix');


INSERT INTO SAE_BienLouable (Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
 VALUES ('BIEN-013','FISC-013','23',40,1,'garage',NULL,'15 Allee de la Gare');
INSERT INTO SAE_BienLouable (Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
 VALUES ('BIEN-003','FISC-003','09',110,5,'logement','BIEN-013','15 Allee de la Gare');

INSERT INTO SAE_BienLouable (Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
 VALUES ('BIEN-012','FISC-012','15',95,4,'logement',NULL,'15 Allee de la Gare');



INSERT INTO SAE_BienLouable (Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
 VALUES ('BIEN-004','FISC-004','03',75,3,'garage',NULL,'7 Rue de la Croix');
 
 INSERT INTO SAE_BienLouable(Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
 VALUES ('BIEN-014','FISC-014','15',80,3,'logement','BIEN-004','7 Rue de la Croix');

INSERT INTO SAE_BienLouable(Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
  VALUES ('BIEN-015','FISC-015','16',35,1,'garage',NULL,'7 Rue de la Croix');



INSERT INTO SAE_BienLouable (Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
Id_BienLouable_2, fk_Adresse_Bat)
VALUES ('BIEN-017','FISC-017','24',38,1,'garage',NULL,'24 Impasse des tomates');

INSERT INTO SAE_BienLouable (Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
 VALUES ('BIEN-005','FISC-005','18 ',30,1,'logement','BIEN-017','24 Impasse des tomates');
 
 INSERT INTO SAE_BienLouable(Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat) 
 VALUES ('BIEN-016','FISC-016','21',52,2,'logement',NULL,'24 Impasse des tomates');





INSERT INTO SAE_BienLouable (Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
 VALUES ('BIEN-006','FISC-006','13',95,4,'garage',NULL,'26 Chemin des pissenlits');

INSERT INTO SAE_BienLouable (Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
 VALUES ('BIEN-018','FISC-018','17',78,3,'logement','BIEN-006','26 Chemin des pissenlits');

INSERT INTO SAE_BienLouable (Id_BienLouable,NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, 
 Id_BienLouable_2, fk_Adresse_Bat)
 VALUES ('BIEN-019','FISC-019','27',28,1,'garage',NULL,'26 Chemin des pissenlits');

























----------------------------------------------------------------------------------------------------------------

INSERT INTO SAE_Locataire (Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, 
 Lieu_de_naissance, Salaire, Profession, Situation_Familiale,  fk_Id_Garant)
VALUES ('LOC-001','Durand','Alice','12 Rue des Lys','0600000001','alice@mail.com','75001','Paris',
        TO_DATE('1994-03-12','YYYY-MM-DD'),'Paris',2100,'Ingenieur','Celibataire','GAR-001');

INSERT INTO SAE_Locataire (Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, 
 Lieu_de_naissance, Salaire, Profession, Situation_Familiale, fk_Id_Garant)
VALUES ('LOC-002','Bernard','Thomas','4 Rue du Port','0600000002','thomas@mail.com','75002','Paris',
        TO_DATE('1988-07-23','YYYY-MM-DD'),'Lyon',1800,'Technicien','Marie','GAR-002');

INSERT INTO SAE_Locataire (Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, 
 Lieu_de_naissance, Salaire, Profession, Situation_Familiale, fk_Id_Garant)
VALUES ('LOC-003','Petit','Laura','10 Rue Nationale','0600000003','laura@mail.com','69001','Lyon',
        TO_DATE('1996-05-10','YYYY-MM-DD'),'Marseille',2500,'Developpeuse','Celibataire','GAR-003');

INSERT INTO SAE_Locataire (Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, 
 Lieu_de_naissance, Salaire, Profession, Situation_Familiale, fk_Id_Garant)
VALUES ('LOC-004','Rossi','Marco','18 Avenue du Parc','0600000004','marco@mail.com','59000','Lille',
        TO_DATE('1984-12-18','YYYY-MM-DD'),'Rouen',1600,'Serveur','Divorce','GAR-004');

INSERT INTO SAE_Locataire (Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, 
 Lieu_de_naissance, Salaire, Profession, Situation_Familiale,  fk_Id_Garant)
VALUES ('LOC-005','Lemoine','Sarah','33 Rue des Écoles','0600000005','sarah@mail.com','33000','Bordeaux',
        TO_DATE('1992-01-05','YYYY-MM-DD'),'Bordeaux',2000,'Infirmiere','Celibataire','GAR-005');

INSERT INTO SAE_Locataire (Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, 
 Lieu_de_naissance, Salaire, Profession, Situation_Familiale, fk_Id_Garant)
VALUES ('LOC-006','Robert','Julien','4 Rue des Lilas','0600000006','julien@mail.com','31000','Toulouse',
        TO_DATE('1990-09-09','YYYY-MM-DD'),'Toulouse',2300,'Professeur','Marie','GAR-006');

INSERT INTO SAE_Locataire (Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, 
 Lieu_de_naissance, Salaire, Profession, Situation_Familiale, fk_Id_Garant)
 VALUES ('LOC-007','Martinez','Elena','15 Rue du Quai','0600000007','elena@mail.com','44000','Nantes',
 TO_DATE('1995-11-02','YYYY-MM-DD'),'Madrid',1900,'Assistante','Celibataire','GAR-007');

INSERT INTO SAE_Locataire (Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, 
 Lieu_de_naissance, Salaire, Profession, Situation_Familiale, fk_Id_Garant)
 VALUES ('LOC-008','Blanc','Cedric','22 Rue Haute','0600000008','cedric@mail.com','13000','Marseille',
 TO_DATE('1987-04-25','YYYY-MM-DD'),'Marseille',2600,'Commercial','Marie','GAR-008');

INSERT INTO SAE_Locataire (Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, 
 Lieu_de_naissance, Salaire, Profession, Situation_Familiale, fk_Id_Garant)
 VALUES ('LOC-009','Fabre','Ines','7 Rue Basse','0600000009','ines@mail.com','34000','Montpellier',
 TO_DATE('1993-08-16','YYYY-MM-DD'),'Montpellier',1700,'Etudiante','Celibataire','GAR-009');

INSERT INTO SAE_Locataire (Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, 
 Lieu_de_naissance, Salaire, Profession, Situation_Familiale, fk_Id_Garant)

 VALUES ('LOC-010','Gillet','Paul','41 Avenue Lumiere','0600000010','paul@mail.com','69008','Lyon',
 TO_DATE('1989-02-11','YYYY-MM-DD'),'Dijon',2800,'Chef de Projet','Marie','GAR-010');

INSERT INTO SAE_Locataire (Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, 
 Lieu_de_naissance, Salaire, Profession, Situation_Familiale, fk_Id_Garant)
 VALUES ('LOC-011','Charpentier','Lucie','28 Rue de Metz','0600000011','lucie@mail.com','31000','Toulouse',
 TO_DATE('1991-12-01','YYYY-MM-DD'),'Toulouse',2200,'Secretaire','Celibataire','GAR-011');

INSERT INTO SAE_Locataire (Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, 
 Lieu_de_naissance, Salaire, Profession, Situation_Familiale, fk_Id_Garant)
 VALUES ('LOC-012','Nguyen','Quentin','19 Rue Victor Hugo','0600000012','quentin@mail.com','21000','Dijon',
 TO_DATE('1997-09-03','YYYY-MM-DD'),'Paris',2400,'Designer','Celibataire','GAR-012');

INSERT INTO SAE_Locataire (Id_Locataire, Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, 
 Lieu_de_naissance, Salaire, Profession, Situation_Familiale, fk_Id_Garant)
 VALUES ('LOC-013','Moreau','Eva','31 Avenue de la Gare','0600000013','eva_m@mail.com','35000','Rennes',
 TO_DATE('1995-06-07','YYYY-MM-DD'),'Rennes',1950,'Coiffeuse','Celibataire','GAR-013');





















---------------------------------------------------------------------------------------------------------------

---TESTER avec 0000-00-Jour  -> Mois et année non accepté, '0001-01-jour' -> Fonctionne
INSERT INTO SAE_ContratLocation (Numero_de_contrat,Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel,
 Date_versement, Index_Compteur_Eau, Index_Compteur_Electricite, Index_Compteur_Gaz, fk_Id_BienLouable)
 VALUES ('CTR-001',TO_DATE('2023-01-01','YYYY-MM-DD'),TO_DATE('2026-01-01','YYYY-MM-DD'),800,40,0,900,TO_DATE('0001-01-01','YYYY-MM-DD'),1020,12500,5100,'BIEN-001');

INSERT INTO SAE_ContratLocation (Numero_de_contrat,Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel,
 Date_versement, Index_Compteur_Eau, Index_Compteur_Electricite, Index_Compteur_Gaz, fk_Id_BienLouable)
 VALUES ('CTR-002',TO_DATE('2023-02-15','YYYY-MM-DD'),TO_DATE('2026-02-15','YYYY-MM-DD'),600,30,0,750,TO_DATE('0001-01-01','YYYY-MM-DD'),23000,3000,5600,'BIEN-002');

INSERT INTO SAE_ContratLocation (Numero_de_contrat,Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel,
 Date_versement, Index_Compteur_Eau, Index_Compteur_Electricite, Index_Compteur_Gaz, fk_Id_BienLouable)
 VALUES ('CTR-003',TO_DATE('2022-10-01','YYYY-MM-DD'),TO_DATE('2025-10-01','YYYY-MM-DD'),1200,50,0,1100,TO_DATE('0001-01-01','YYYY-MM-DD'),5000,3500,18000,'BIEN-003');

INSERT INTO SAE_ContratLocation (Numero_de_contrat,Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel,
 Date_versement, Index_Compteur_Eau, Index_Compteur_Electricite, Index_Compteur_Gaz, fk_Id_BienLouable)
 VALUES ('CTR-004',TO_DATE('2023-03-20','YYYY-MM-DD'),TO_DATE('2026-03-20','YYYY-MM-DD'),900,40,0,950,TO_DATE('0001-01-01','YYYY-MM-DD'),3000,3500,6000,'BIEN-004');

INSERT INTO SAE_ContratLocation (Numero_de_contrat,Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel,
 Date_versement, Index_Compteur_Eau, Index_Compteur_Electricite, Index_Compteur_Gaz, fk_Id_BienLouable)
 VALUES ('CTR-005',TO_DATE('2023-05-01','YYYY-MM-DD'),TO_DATE('2026-05-01','YYYY-MM-DD'),500,20,0,700,TO_DATE('0001-01-01','YYYY-MM-DD'),8000,1350,4800,'BIEN-005');

INSERT INTO SAE_ContratLocation (Numero_de_contrat,Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel,
 Date_versement, Index_Compteur_Eau, Index_Compteur_Electricite, Index_Compteur_Gaz, fk_Id_BienLouable)
 VALUES ('CTR-006',TO_DATE('2022-09-10','YYYY-MM-DD'),TO_DATE('2025-09-10','YYYY-MM-DD'),1000,35,0,1050,TO_DATE('0001-01-01','YYYY-MM-DD'),10000,2500,9000,'BIEN-006');

INSERT INTO SAE_ContratLocation (Numero_de_contrat,Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel,
 Date_versement, Index_Compteur_Eau, Index_Compteur_Electricite, Index_Compteur_Gaz, fk_Id_BienLouable)
 VALUES ('CTR-007',TO_DATE('2023-02-01','YYYY-MM-DD'),TO_DATE('2026-02-01','YYYY-MM-DD'),850,50,0,850,TO_DATE('0001-01-01','YYYY-MM-DD'),5000,1500,3600,'BIEN-007');

INSERT INTO SAE_ContratLocation (Numero_de_contrat,Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel,
 Date_versement, Index_Compteur_Eau, Index_Compteur_Electricite, Index_Compteur_Gaz, fk_Id_BienLouable)
 VALUES ('CTR-008',TO_DATE('2023-03-01','YYYY-MM-DD'),TO_DATE('2026-03-01','YYYY-MM-DD'),950,50,0,950,TO_DATE('0001-01-01','YYYY-MM-DD'),8200,1100,2800,'BIEN-008');

INSERT INTO SAE_ContratLocation (Numero_de_contrat,Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel,
 Date_versement, Index_Compteur_Eau, Index_Compteur_Electricite, Index_Compteur_Gaz, fk_Id_BienLouable)
 VALUES ('CTR-009',TO_DATE('2023-03-15','YYYY-MM-DD'),TO_DATE('2026-03-15','YYYY-MM-DD'),650,40,0,800,TO_DATE('0001-01-01','YYYY-MM-DD'),9000,2000,5000,'BIEN-009');

INSERT INTO SAE_ContratLocation (Numero_de_contrat,Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel,
 Date_versement, Index_Compteur_Eau, Index_Compteur_Electricite, Index_Compteur_Gaz, fk_Id_BienLouable)
 VALUES ('CTR-010',TO_DATE('2023-04-15','YYYY-MM-DD'),TO_DATE('2026-04-15','YYYY-MM-DD'),650,50,0,900,TO_DATE('0001-01-01','YYYY-MM-DD'),6500,1700,4500,'BIEN-010');

 INSERT INTO SAE_ContratLocation (Numero_de_contrat,Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel,
 Date_versement, Index_Compteur_Eau, Index_Compteur_Electricite, Index_Compteur_Gaz, fk_Id_BienLouable)
 VALUES ('CTR-011',TO_DATE('2022-11-01','YYYY-MM-DD'),TO_DATE('2025-11-01','YYYY-MM-DD'),1250,100,0,1100,TO_DATE('0001-01-01','YYYY-MM-DD'),7200,2100,5200,'BIEN-011');

INSERT INTO SAE_ContratLocation (Numero_de_contrat,Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel,
 Date_versement, Index_Compteur_Eau, Index_Compteur_Electricite, Index_Compteur_Gaz, fk_Id_BienLouable)
 VALUES ('CTR-012',TO_DATE('2022-12-01','YYYY-MM-DD'),TO_DATE('2025-12-01','YYYY-MM-DD'),1250,150,0,1100,TO_DATE('0001-01-01','YYYY-MM-DD'),6800,1600,3900,'BIEN-012');

 INSERT INTO SAE_ContratLocation (Numero_de_contrat,Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel,
 Date_versement, Index_Compteur_Eau, Index_Compteur_Electricite, Index_Compteur_Gaz, fk_Id_BienLouable)
 VALUES ('CTR-013',TO_DATE('2023-03-17','YYYY-MM-DD'),TO_DATE('2026-03-17','YYYY-MM-DD'),700,50,0,800,TO_DATE('0001-01-01','YYYY-MM-DD'),8400,2300,4200,'BIEN-013');






















----------------------------------------------------------------------------------------------------------------
INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-001','Entretien',80,10,1.0,TO_DATE('2022-01-10','YYYY-MM-DD'),'BIEN-001');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-002','Ascenseur',60,8,0.8,TO_DATE('2022-01-11','YYYY-MM-DD'),'BIEN-001');

 INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-0036','Nettoyage',65,9,0.9,TO_DATE('2022-01-12','YYYY-MM-DD'),'BIEN-001');



INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-003','Entretien',85,10,1.1,TO_DATE('2022-01-11','YYYY-MM-DD'),'BIEN-007');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-004','Ascenseur',65,9,0.9,TO_DATE('2022-01-12','YYYY-MM-DD'),'BIEN-007');

 INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-0037','Nettoyage',60,8,0.8,TO_DATE('2022-01-11','YYYY-MM-DD'),'BIEN-007');



INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-005','Entretien',40,5,0.5,TO_DATE('2022-01-12','YYYY-MM-DD'),'BIEN-008');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-006','Parking',30,4,0.4,TO_DATE('2022-01-13','YYYY-MM-DD'),'BIEN-008');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-0038','Nettoyage',60,8,0.8,TO_DATE('2022-01-11','YYYY-MM-DD'),'BIEN-008');




INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-007','Entretien',45,6,0.5,TO_DATE('2022-01-13','YYYY-MM-DD'),'BIEN-002');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-008','Ascenseur',55,7,0.7,TO_DATE('2022-01-14','YYYY-MM-DD'),'BIEN-002');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-0039','Nettoyage',60,8,0.8,TO_DATE('2022-01-11','YYYY-MM-DD'),'BIEN-002');



INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-009','Entretien',90,12,1.2,TO_DATE('2022-01-14','YYYY-MM-DD'),'BIEN-009');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-010','Ascenseur',60,9,0.9,TO_DATE('2022-01-15','YYYY-MM-DD'),'BIEN-009');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-0040','Nettoyage',60,8,0.8,TO_DATE('2022-01-11','YYYY-MM-DD'),'BIEN-009');



INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-011','Entretien',50,7,0.6,TO_DATE('2022-01-15','YYYY-MM-DD'),'BIEN-010');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-012','Ascenseur',55,7,0.7,TO_DATE('2022-01-16','YYYY-MM-DD'),'BIEN-010');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-0041','Nettoyage',60,8,0.8,TO_DATE('2022-01-11','YYYY-MM-DD'),'BIEN-010');



INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-013','Entretien',70,9,1.0,TO_DATE('2022-01-16','YYYY-MM-DD'),'BIEN-011');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-014','Nettoyage',40,5,0.6,TO_DATE('2022-01-17','YYYY-MM-DD'),'BIEN-011');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-0042','Nettoyage',60,8,0.8,TO_DATE('2022-01-11','YYYY-MM-DD'),'BIEN-011');


INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-017','Entretien',88,11,1.2,TO_DATE('2022-01-17','YYYY-MM-DD'),'BIEN-012');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-018','Ascenseur',58,8,0.8,TO_DATE('2022-01-18','YYYY-MM-DD'),'BIEN-012');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-0043','Nettoyage',60,8,0.8,TO_DATE('2022-01-11','YYYY-MM-DD'),'BIEN-012');


INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-019','Entretien',42,5,0.5,TO_DATE('2022-01-19','YYYY-MM-DD'),'BIEN-013');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-020','Ascenseur',55,7,0.7,TO_DATE('2022-01-20','YYYY-MM-DD'),'BIEN-013');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-035','Nettoyage',55,7,0.7,TO_DATE('2022-01-20','YYYY-MM-DD'),'BIEN-013');





INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-021','Entretien',35,5,0.4,TO_DATE('2022-01-20','YYYY-MM-DD'),'BIEN-004');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-022','Parking',25,3,0.3,TO_DATE('2022-01-21','YYYY-MM-DD'),'BIEN-004');

 
INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-0044','Nettoyage',60,8,0.8,TO_DATE('2022-01-11','YYYY-MM-DD'),'BIEN-004');


INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-027','Entretien',75,9,1.0,TO_DATE('2022-01-21','YYYY-MM-DD'),'BIEN-005');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-028','Ascenseur',58,8,0.8,TO_DATE('2022-01-22','YYYY-MM-DD'),'BIEN-005');
 
INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-0045','Nettoyage',60,8,0.8,TO_DATE('2022-01-11','YYYY-MM-DD'),'BIEN-005');




INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-033','Entretien',48,6,0.6,TO_DATE('2022-01-22','YYYY-MM-DD'),'BIEN-006');

INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-034','Ascenseur',52,7,0.7,TO_DATE('2022-01-23','YYYY-MM-DD'),'BIEN-006');

 
INSERT INTO SAE_Charges_Generale (Id_Charges_Generale,Type_Charge, Montant_Total, Pourcentage, Quotite, Date_Charge, fk_Id_BienLouable)
 VALUES ('CHG-0046','Nettoyage',60,8,0.8,TO_DATE('2022-01-11','YYYY-MM-DD'),'BIEN-006');
 

























----------------------------------------------------------------------------------------------------------------


INSERT INTO SAE_Diagnostics VALUES ('DIA-001','DPE',TO_DATE('2022-01-10','YYYY-MM-DD'),TO_DATE('2032-01-10','YYYY-MM-DD'),'dpe001.pdf','BIEN-001');
INSERT INTO SAE_Diagnostics VALUES ('DIA-002','Electricite',TO_DATE('2025-02-10','YYYY-MM-DD'),TO_DATE('2035-02-10','YYYY-MM-DD'),'elec001.pdf','BIEN-001');
INSERT INTO SAE_Diagnostics VALUES ('DIA-003','Gaz',TO_DATE('2023-03-10','YYYY-MM-DD'),TO_DATE('2033-03-10','YYYY-MM-DD'),'gaz001.pdf','BIEN-001');

-- BIEN-002
INSERT INTO SAE_Diagnostics VALUES ('DIA-004','DPE',TO_DATE('2023-01-15','YYYY-MM-DD'),TO_DATE('2033-01-15','YYYY-MM-DD'),'dpe002.pdf','BIEN-002');
INSERT INTO SAE_Diagnostics VALUES ('DIA-005','Electricite',TO_DATE('2024-02-15','YYYY-MM-DD'),TO_DATE('2034-02-15','YYYY-MM-DD'),'elec002.pdf','BIEN-002');
INSERT INTO SAE_Diagnostics VALUES ('DIA-006','Gaz',TO_DATE('2022-03-15','YYYY-MM-DD'),TO_DATE('2032-03-15','YYYY-MM-DD'),'gaz002.pdf','BIEN-002');

-- BIEN-003
INSERT INTO SAE_Diagnostics VALUES ('DIA-007','DPE',TO_DATE('2022-01-20','YYYY-MM-DD'),TO_DATE('2032-01-20','YYYY-MM-DD'),'dpe003.pdf','BIEN-003');
INSERT INTO SAE_Diagnostics VALUES ('DIA-008','Electricite',TO_DATE('2024-02-20','YYYY-MM-DD'),TO_DATE('2034-02-20','YYYY-MM-DD'),'elec003.pdf','BIEN-003');
INSERT INTO SAE_Diagnostics VALUES ('DIA-009','Gaz',TO_DATE('2023-03-20','YYYY-MM-DD'),TO_DATE('2033-03-20','YYYY-MM-DD'),'gaz003.pdf','BIEN-003');

-- BIEN-004
INSERT INTO SAE_Diagnostics VALUES ('DIA-010','DPE',TO_DATE('2023-01-25','YYYY-MM-DD'),TO_DATE('2033-01-25','YYYY-MM-DD'),'dpe004.pdf','BIEN-004');
INSERT INTO SAE_Diagnostics VALUES ('DIA-011','Electricite',TO_DATE('2024-02-25','YYYY-MM-DD'),TO_DATE('2034-02-25','YYYY-MM-DD'),'elec004.pdf','BIEN-004');
INSERT INTO SAE_Diagnostics VALUES ('DIA-012','Gaz',TO_DATE('2025-03-25','YYYY-MM-DD'),TO_DATE('2035-03-25','YYYY-MM-DD'),'gaz004.pdf','BIEN-004');

-- BIEN-005
INSERT INTO SAE_Diagnostics VALUES ('DIA-013','DPE',TO_DATE('2022-01-30','YYYY-MM-DD'),TO_DATE('2032-01-30','YYYY-MM-DD'),'dpe005.pdf','BIEN-005');
INSERT INTO SAE_Diagnostics VALUES ('DIA-014','Electricite',TO_DATE('2024-02-28','YYYY-MM-DD'),TO_DATE('2034-02-28','YYYY-MM-DD'),'elec005.pdf','BIEN-005');
INSERT INTO SAE_Diagnostics VALUES ('DIA-015','Gaz',TO_DATE('2023-03-30','YYYY-MM-DD'),TO_DATE('2033-03-30','YYYY-MM-DD'),'gaz005.pdf','BIEN-005');

-- BIEN-006
INSERT INTO SAE_Diagnostics VALUES ('DIA-016','DPE',TO_DATE('2022-04-05','YYYY-MM-DD'),TO_DATE('2032-04-05','YYYY-MM-DD'),'dpe006.pdf','BIEN-006');
INSERT INTO SAE_Diagnostics VALUES ('DIA-017','Electricite',TO_DATE('2024-04-10','YYYY-MM-DD'),TO_DATE('2034-04-10','YYYY-MM-DD'),'elec006.pdf','BIEN-006');
INSERT INTO SAE_Diagnostics VALUES ('DIA-018','Gaz',TO_DATE('2025-04-15','YYYY-MM-DD'),TO_DATE('2035-04-15','YYYY-MM-DD'),'gaz006.pdf','BIEN-006');

-- BIEN-007
INSERT INTO SAE_Diagnostics VALUES ('DIA-019','DPE',TO_DATE('2023-04-20','YYYY-MM-DD'),TO_DATE('2033-04-20','YYYY-MM-DD'),'dpe007.pdf','BIEN-007');
INSERT INTO SAE_Diagnostics VALUES ('DIA-020','Electricite',TO_DATE('2024-04-25','YYYY-MM-DD'),TO_DATE('2034-04-25','YYYY-MM-DD'),'elec007.pdf','BIEN-007');
INSERT INTO SAE_Diagnostics VALUES ('DIA-021','Gaz',TO_DATE('2022-04-30','YYYY-MM-DD'),TO_DATE('2032-04-30','YYYY-MM-DD'),'gaz007.pdf','BIEN-007');

-- BIEN-008
INSERT INTO SAE_Diagnostics VALUES ('DIA-022','DPE',TO_DATE('2023-05-05','YYYY-MM-DD'),TO_DATE('2033-05-05','YYYY-MM-DD'),'dpe008.pdf','BIEN-008');
INSERT INTO SAE_Diagnostics VALUES ('DIA-023','Electricite',TO_DATE('2024-05-10','YYYY-MM-DD'),TO_DATE('2034-05-10','YYYY-MM-DD'),'elec008.pdf','BIEN-008');
INSERT INTO SAE_Diagnostics VALUES ('DIA-024','Gaz',TO_DATE('2025-05-15','YYYY-MM-DD'),TO_DATE('2035-05-15','YYYY-MM-DD'),'gaz008.pdf','BIEN-008');



-- BIEN-009
INSERT INTO SAE_Diagnostics VALUES ('DIA-025','DPE',TO_DATE('2024-05-20','YYYY-MM-DD'),TO_DATE('2034-05-20','YYYY-MM-DD'),'dpe009.pdf','BIEN-009');
INSERT INTO SAE_Diagnostics VALUES ('DIA-026','Electricite',TO_DATE('2022-05-25','YYYY-MM-DD'),TO_DATE('2032-05-25','YYYY-MM-DD'),'elec009.pdf','BIEN-009');
INSERT INTO SAE_Diagnostics VALUES ('DIA-027','Gaz',TO_DATE('2023-05-30','YYYY-MM-DD'),TO_DATE('2033-05-30','YYYY-MM-DD'),'gaz009.pdf','BIEN-009');

-- BIEN-010
INSERT INTO SAE_Diagnostics VALUES ('DIA-028','DPE',TO_DATE('2024-06-05','YYYY-MM-DD'),TO_DATE('2034-06-05','YYYY-MM-DD'),'dpe010.pdf','BIEN-010');
INSERT INTO SAE_Diagnostics VALUES ('DIA-029','Electricite',TO_DATE('2025-06-10','YYYY-MM-DD'),TO_DATE('2035-06-10','YYYY-MM-DD'),'elec010.pdf','BIEN-010');
INSERT INTO SAE_Diagnostics VALUES ('DIA-030','Gaz',TO_DATE('2022-06-15','YYYY-MM-DD'),TO_DATE('2032-06-15','YYYY-MM-DD'),'gaz010.pdf','BIEN-010');

-- BIEN-011
INSERT INTO SAE_Diagnostics VALUES ('DIA-031','DPE',TO_DATE('2024-06-20','YYYY-MM-DD'),TO_DATE('2034-06-20','YYYY-MM-DD'),'dpe011.pdf','BIEN-011');
INSERT INTO SAE_Diagnostics VALUES ('DIA-032','Electricite',TO_DATE('2022-06-25','YYYY-MM-DD'),TO_DATE('2032-06-25','YYYY-MM-DD'),'elec011.pdf','BIEN-011');
INSERT INTO SAE_Diagnostics VALUES ('DIA-033','Gaz',TO_DATE('2023-06-30','YYYY-MM-DD'),TO_DATE('2033-06-30','YYYY-MM-DD'),'gaz011.pdf','BIEN-011');

-- BIEN-012
INSERT INTO SAE_Diagnostics VALUES ('DIA-034','DPE',TO_DATE('2022-07-05','YYYY-MM-DD'),TO_DATE('2032-07-05','YYYY-MM-DD'),'dpe012.pdf','BIEN-012');
INSERT INTO SAE_Diagnostics VALUES ('DIA-035','Electricite',TO_DATE('2025-07-10','YYYY-MM-DD'),TO_DATE('2035-07-10','YYYY-MM-DD'),'elec012.pdf','BIEN-012');
INSERT INTO SAE_Diagnostics VALUES ('DIA-036','Gaz',TO_DATE('2024-07-15','YYYY-MM-DD'),TO_DATE('2034-07-15','YYYY-MM-DD'),'gaz012.pdf','BIEN-012');

-- BIEN-013
INSERT INTO SAE_Diagnostics VALUES ('DIA-037','DPE',TO_DATE('2024-07-20','YYYY-MM-DD'),TO_DATE('2034-07-20','YYYY-MM-DD'),'dpe013.pdf','BIEN-013');
INSERT INTO SAE_Diagnostics VALUES ('DIA-038','Electricite',TO_DATE('2023-07-25','YYYY-MM-DD'),TO_DATE('2033-07-25','YYYY-MM-DD'),'elec013.pdf','BIEN-013');
INSERT INTO SAE_Diagnostics VALUES ('DIA-039','Gaz',TO_DATE('2022-07-30','YYYY-MM-DD'),TO_DATE('2032-07-30','YYYY-MM-DD'),'gaz013.pdf','BIEN-013');

-- BIEN-014
INSERT INTO SAE_Diagnostics VALUES ('DIA-040','DPE',TO_DATE('2023-08-05','YYYY-MM-DD'),TO_DATE('2033-08-05','YYYY-MM-DD'),'dpe014.pdf','BIEN-014');
INSERT INTO SAE_Diagnostics VALUES ('DIA-041','Electricite',TO_DATE('2024-08-10','YYYY-MM-DD'),TO_DATE('2034-08-10','YYYY-MM-DD'),'elec014.pdf','BIEN-014');
INSERT INTO SAE_Diagnostics VALUES ('DIA-042','Gaz',TO_DATE('2025-08-15','YYYY-MM-DD'),TO_DATE('2035-08-15','YYYY-MM-DD'),'gaz014.pdf','BIEN-014');

-- BIEN-015
INSERT INTO SAE_Diagnostics VALUES ('DIA-043','DPE',TO_DATE('2025-08-20','YYYY-MM-DD'),TO_DATE('2035-08-20','YYYY-MM-DD'),'dpe015.pdf','BIEN-015');
INSERT INTO SAE_Diagnostics VALUES ('DIA-044','Electricite',TO_DATE('2024-08-25','YYYY-MM-DD'),TO_DATE('2034-08-25','YYYY-MM-DD'),'elec015.pdf','BIEN-015');
INSERT INTO SAE_Diagnostics VALUES ('DIA-045','Gaz',TO_DATE('2023-08-30','YYYY-MM-DD'),TO_DATE('2033-08-30','YYYY-MM-DD'),'gaz015.pdf','BIEN-015');

-- BIEN-016
INSERT INTO SAE_Diagnostics VALUES ('DIA-046','DPE',TO_DATE('2023-09-05','YYYY-MM-DD'),TO_DATE('2033-09-05','YYYY-MM-DD'),'dpe016.pdf','BIEN-016');
INSERT INTO SAE_Diagnostics VALUES ('DIA-047','Electricite',TO_DATE('2022-09-10','YYYY-MM-DD'),TO_DATE('2032-09-10','YYYY-MM-DD'),'elec016.pdf','BIEN-016');
INSERT INTO SAE_Diagnostics VALUES ('DIA-048','Gaz',TO_DATE('2024-09-15','YYYY-MM-DD'),TO_DATE('2034-09-15','YYYY-MM-DD'),'gaz016.pdf','BIEN-016');

-- BIEN-017
INSERT INTO SAE_Diagnostics VALUES ('DIA-049','DPE',TO_DATE('2024-09-20','YYYY-MM-DD'),TO_DATE('2034-09-20','YYYY-MM-DD'),'dpe017.pdf','BIEN-017');
INSERT INTO SAE_Diagnostics VALUES ('DIA-050','Electricite',TO_DATE('2025-09-25','YYYY-MM-DD'),TO_DATE('2035-09-25','YYYY-MM-DD'),'elec017.pdf','BIEN-017');
INSERT INTO SAE_Diagnostics VALUES ('DIA-051','Gaz',TO_DATE('2022-09-30','YYYY-MM-DD'),TO_DATE('2032-09-30','YYYY-MM-DD'),'gaz017.pdf','BIEN-017');

-- BIEN-018
INSERT INTO SAE_Diagnostics VALUES ('DIA-052','DPE',TO_DATE('2022-10-05','YYYY-MM-DD'),TO_DATE('2032-10-05','YYYY-MM-DD'),'dpe018.pdf','BIEN-018');
INSERT INTO SAE_Diagnostics VALUES ('DIA-053','Electricite',TO_DATE('2024-10-10','YYYY-MM-DD'),TO_DATE('2034-10-10','YYYY-MM-DD'),'elec018.pdf','BIEN-018');
INSERT INTO SAE_Diagnostics VALUES ('DIA-054','Gaz',TO_DATE('2023-10-15','YYYY-MM-DD'),TO_DATE('2033-10-15','YYYY-MM-DD'),'gaz018.pdf','BIEN-018');

-- BIEN-019
INSERT INTO SAE_Diagnostics VALUES ('DIA-055','DPE',TO_DATE('2023-10-20','YYYY-MM-DD'),TO_DATE('2033-10-20','YYYY-MM-DD'),'dpe019.pdf','BIEN-019');
INSERT INTO SAE_Diagnostics VALUES ('DIA-056','Electricite',TO_DATE('2022-10-25','YYYY-MM-DD'),TO_DATE('2032-10-25','YYYY-MM-DD'),'elec019.pdf','BIEN-019');
INSERT INTO SAE_Diagnostics VALUES ('DIA-057','Gaz',TO_DATE('2025-10-30','YYYY-MM-DD'),TO_DATE('2035-10-30','YYYY-MM-DD'),'gaz019.pdf','BIEN-019');






















----------------------------------------------------------------------------------------------------------------
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2018, 127.22, 1);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2018, 127.77, 2);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2018, 128.45, 3);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2018, 129.03, 4);

INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2019, 129.38, 1);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2019, 129.72, 2);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2019, 129.99, 3);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2019, 130.26, 4);

INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2020, 130.57, 1);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2020, 130.57 ,2);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2020, 130.59 ,3);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2020, 130.52 ,4);

INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2021, 130.69, 1);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2021, 131.12, 2);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2021, 131.67, 3);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2021, 132.62, 4);

INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2022, 133.93, 1);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2022, 135.84, 2);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2022, 136.27, 3);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2022, 137.26, 4);

INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2023, 138.61, 1);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2023, 140.59, 2);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2023, 141.03, 3);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2023, 142.06, 4);

INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2024, 143.46, 1);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2024, 145.17, 2);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2024, 144.51, 3);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2024, 144.64, 4);

INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2025, 145.47, 1);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2025, 146.68, 2);
INSERT INTO SAE_IRL (Annee, IRL, Trimestre) VALUES (2025, 145.77, 3);






















----------------------------------------------------------------------------------------------------------------

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat,Designation_Paiement)
    VALUES ('PAY-001',900,TO_DATE('2023-02-01','YYYY-MM-DD'),'CTR-001','Charges');

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat,Designation_Paiement)
    VALUES ('PAY-002',750,TO_DATE('2024-03-01','YYYY-MM-DD'),'CTR-002','Loyer');

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat,Designation_Paiement)
    VALUES ('PAY-003',1100,TO_DATE('2025-01-01','YYYY-MM-DD'),'CTR-003','Charges');

INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat,Designation_Paiement)
    VALUES ('PAY-004',950,TO_DATE('2023-04-05','YYYY-MM-DD'),'CTR-004','Loyer');

INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat,Designation_Paiement)
    VALUES ('PAY-005',700,TO_DATE('2025-06-01','YYYY-MM-DD'),'CTR-005','Charges');

INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat,Designation_Paiement)
    VALUES ('PAY-006',1050,TO_DATE('2024-10-01','YYYY-MM-DD'),'CTR-006','Loyer');

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat,Designation_Paiement)
    VALUES ('PAY-007',900,TO_DATE('2023-02-01','YYYY-MM-DD'),'CTR-007','Loyer');

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat,Designation_Paiement)
    VALUES ('PAY-008',750,TO_DATE('2024-03-01','YYYY-MM-DD'),'CTR-008','Loyer');

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat,Designation_Paiement)
    VALUES ('PAY-009',1100,TO_DATE('2023-01-01','YYYY-MM-DD'),'CTR-009','Charges');

INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat,Designation_Paiement)
    VALUES ('PAY-010',950,TO_DATE('2025-04-05','YYYY-MM-DD'),'CTR-010','Loyer');

INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat,Designation_Paiement)
    VALUES ('PAY-011',700,TO_DATE('2025-06-01','YYYY-MM-DD'),'CTR-011','Charges');

INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat,Designation_Paiement)
    VALUES ('PAY-012',1050,TO_DATE('2023-10-01','YYYY-MM-DD'),'CTR-012','Loyer');

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat,Designation_Paiement)
    VALUES ('PAY-013',900,TO_DATE('2024-02-01','YYYY-MM-DD'),'CTR-013','Charges');



INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-014',900,TO_DATE('2023-03-01','YYYY-MM-DD'),'CTR-001');

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-015',750,TO_DATE('2024-04-01','YYYY-MM-DD'),'CTR-002');

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-016',1100,TO_DATE('2025-02-01','YYYY-MM-DD'),'CTR-003');

INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-017',950,TO_DATE('2023-05-05','YYYY-MM-DD'),'CTR-004');

INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-018',700,TO_DATE('2025-07-01','YYYY-MM-DD'),'CTR-005');

INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-019',1050,TO_DATE('2024-08-01','YYYY-MM-DD'),'CTR-006');

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-020',900,TO_DATE('2023-09-01','YYYY-MM-DD'),'CTR-007');

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-021',750,TO_DATE('2024-04-01','YYYY-MM-DD'),'CTR-008');

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-022',1100,TO_DATE('2023-02-01','YYYY-MM-DD'),'CTR-009');

INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-023',950,TO_DATE('2025-05-05','YYYY-MM-DD'),'CTR-010');

INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-024',700,TO_DATE('2025-07-01','YYYY-MM-DD'),'CTR-011');

INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-025',1050,TO_DATE('2023-11-01','YYYY-MM-DD'),'CTR-012');

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-026',900,TO_DATE('2024-03-01','YYYY-MM-DD'),'CTR-013');





INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-027',900,TO_DATE('2023-04-01','YYYY-MM-DD'),'CTR-001');

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-028',750,TO_DATE('2024-05-01','YYYY-MM-DD'),'CTR-002');

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-029',1100,TO_DATE('2025-03-01','YYYY-MM-DD'),'CTR-003');

INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-030',950,TO_DATE('2023-06-05','YYYY-MM-DD'),'CTR-004');

INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-031',700,TO_DATE('2025-08-01','YYYY-MM-DD'),'CTR-005');

INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-032',1050,TO_DATE('2024-09-01','YYYY-MM-DD'),'CTR-006');

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-033',900,TO_DATE('2023-10-01','YYYY-MM-DD'),'CTR-007');

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-034',750,TO_DATE('2024-05-01','YYYY-MM-DD'),'CTR-008');

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-035',1100,TO_DATE('2023-03-01','YYYY-MM-DD'),'CTR-009');

INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-036',950,TO_DATE('2025-06-05','YYYY-MM-DD'),'CTR-010');

INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-037',700,TO_DATE('2025-08-01','YYYY-MM-DD'),'CTR-011');

INSERT INTO SAE_Paiement(Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-038',1050,TO_DATE('2023-12-01','YYYY-MM-DD'),'CTR-012');

INSERT INTO SAE_Paiement (Id_Paiement, Montant, Date_Paiement, fk_Numero_de_contrat)
    VALUES ('PAY-039',900,TO_DATE('2024-04-01','YYYY-MM-DD'),'CTR-013');


















----------------------------------------------------------------------------------------------------------------
INSERT INTO SAE_Assurance (Numero_d_assurance, Prime, Montant, Type_assurance, Agence, Adresse_agence, Tel_agence, fk_Adresse)
 VALUES ('ASS-001',200,120,'Proprietaire','LesFurets','12 Rue Blanche','0145002001','20 Chemin La Fayette');

INSERT INTO SAE_Assurance (Numero_d_assurance, Prime, Montant, Type_assurance, Agence, Adresse_agence, Tel_agence, fk_Adresse)
 VALUES ('ASS-002',250,140,'Aide juridique','MAIF','8 Rue des Arts','0145203001','31 Rue de la Paix');

INSERT INTO SAE_Assurance (Numero_d_assurance, Prime, Montant, Type_assurance, Agence, Adresse_agence, Tel_agence, fk_Adresse)
 VALUES ('ASS-003',300,160,'Proprietaire','LeLynx','5 Rue du Moulin','0145304001','15 Allee de la Gare');

INSERT INTO SAE_Assurance (Numero_d_assurance, Prime, Montant, Type_assurance, Agence, Adresse_agence, Tel_agence, fk_Adresse)
 VALUES ('ASS-004',180,100,'Proprietaire','LaMAE','3 Rue Verte','0145506001','7 Rue de la Croix');

INSERT INTO SAE_Assurance (Numero_d_assurance, Prime, Montant, Type_assurance, Agence, Adresse_agence, Tel_agence, fk_Adresse)
 VALUES ('ASS-005',220,130,'Proprietaire','AbeilleAssurance','15 Avenue Est','0145607001','24 Impasse des tomates'); 

INSERT INTO SAE_Assurance (Numero_d_assurance, Prime, Montant, Type_assurance, Agence, Adresse_agence, Tel_agence, fk_Adresse)
 VALUES ('ASS-006',240,150,'Aide juridique','ABE','9 Rue Royale','0145708001','26 Chemin des pissenlits');




















----------------------------------------------------------------------------------------------------------------
INSERT INTO SAE_Compteur VALUES 
('COMP-001',30,12,42,'Eau',TO_DATE('2019-01-01','YYYY-MM-DD'),1020,1085,'BIEN-001');

INSERT INTO SAE_Compteur VALUES 
('COMP-014',48,22,70,'Electricite',TO_DATE('2018-05-15','YYYY-MM-DD'),12500,13950,'BIEN-001');

INSERT INTO SAE_Compteur VALUES 
('COMP-015',33,18,51,'Gaz',TO_DATE('2019-02-11','YYYY-MM-DD'),5100,5900,'BIEN-001');



INSERT INTO SAE_Compteur VALUES 
('COMP-002',40,18,58,'Electricite',TO_DATE('2020-05-12','YYYY-MM-DD'),23000,24500,'BIEN-002');

INSERT INTO SAE_Compteur VALUES 
('COMP-016',28,9,37,'Eau',TO_DATE('2017-07-01','YYYY-MM-DD'),3000,3075,'BIEN-002');

INSERT INTO SAE_Compteur VALUES 
('COMP-017',30,12,42,'Gaz',TO_DATE('2019-10-22','YYYY-MM-DD'),5600,6400,'BIEN-002');




INSERT INTO SAE_Compteur VALUES 
('COMP-003',35,20,55,'Gaz',TO_DATE('2018-08-08','YYYY-MM-DD'),5000,6100,'BIEN-003');

INSERT INTO SAE_Compteur VALUES 
('COMP-018',40,16,56,'Eau',TO_DATE('2018-05-09','YYYY-MM-DD'),3500,3580,'BIEN-003');

INSERT INTO SAE_Compteur VALUES 
('COMP-019',55,25,80,'Electricite',TO_DATE('2020-01-15','YYYY-MM-DD'),18000,19800,'BIEN-003');


INSERT INTO SAE_Compteur VALUES 
('COMP-004',45,15,60,'Eau',TO_DATE('2021-02-02','YYYY-MM-DD'),3000,3065,'BIEN-004');

INSERT INTO SAE_Compteur VALUES 
('COMP-020',47,21,68,'Electricite',TO_DATE('2021-04-04','YYYY-MM-DD'),3900,5200,'BIEN-004');

INSERT INTO SAE_Compteur VALUES 
('COMP-021',32,14,46,'Gaz',TO_DATE('2022-06-06','YYYY-MM-DD'),6000,6900,'BIEN-004');


INSERT INTO SAE_Compteur VALUES 
('COMP-005',50,25,75,'Electricite',TO_DATE('2020-09-17','YYYY-MM-DD'),8000,9800,'BIEN-005');

INSERT INTO SAE_Compteur VALUES 
('COMP-022',18,7,25,'Eau',TO_DATE('2020-11-10','YYYY-MM-DD'),1350,1420,'BIEN-005');

INSERT INTO SAE_Compteur VALUES 
('COMP-023',27,11,38,'Gaz',TO_DATE('2021-09-14','YYYY-MM-DD'),4800,5600,'BIEN-005');



INSERT INTO SAE_Compteur VALUES 
('COMP-006',38,17,55,'Gaz',TO_DATE('2022-03-10','YYYY-MM-DD'),10000,11500,'BIEN-006');

INSERT INTO SAE_Compteur VALUES 
('COMP-024',36,15,51,'Eau',TO_DATE('2018-02-15','YYYY-MM-DD'),2500,2575,'BIEN-006');

INSERT INTO SAE_Compteur VALUES 
('COMP-025',52,26,78,'Electricite',TO_DATE('2021-03-03','YYYY-MM-DD'),9000,11000,'BIEN-006');



INSERT INTO SAE_Compteur VALUES 
('COMP-026',40,19,59,'Electricite',TO_DATE('2021-10-21','YYYY-MM-DD'),5000,6800,'BIEN-007');

INSERT INTO SAE_Compteur VALUES 
('COMP-027',22,9,31,'Eau',TO_DATE('2019-06-09','YYYY-MM-DD'),1500,1580,'BIEN-007');

INSERT INTO SAE_Compteur VALUES 
('COMP-028',34,16,50,'Gaz',TO_DATE('2020-02-13','YYYY-MM-DD'),3600,4500,'BIEN-007');


INSERT INTO SAE_Compteur VALUES 
('COMP-029',47,23,70,'Electricite',TO_DATE('2020-11-30','YYYY-MM-DD'),8200,10200,'BIEN-008');

INSERT INTO SAE_Compteur VALUES 
('COMP-030',21,8,29,'Eau',TO_DATE('2017-09-08','YYYY-MM-DD'),1100,1180,'BIEN-008');

INSERT INTO SAE_Compteur VALUES 
('COMP-031',32,12,44,'Gaz',TO_DATE('2019-05-16','YYYY-MM-DD'),2800,3600,'BIEN-008');


INSERT INTO SAE_Compteur VALUES 
('COMP-032',52,26,78,'Electricite',TO_DATE('2021-03-15','YYYY-MM-DD'),9000,11200,'BIEN-009');

INSERT INTO SAE_Compteur VALUES 
('COMP-033',24,11,35,'Eau',TO_DATE('2020-06-10','YYYY-MM-DD'),2000,2080,'BIEN-009');

INSERT INTO SAE_Compteur VALUES 
('COMP-034',38,18,56,'Gaz',TO_DATE('2018-08-25','YYYY-MM-DD'),5000,6200,'BIEN-009');


INSERT INTO SAE_Compteur VALUES 
('COMP-035',46,21,67,'Electricite',TO_DATE('2019-10-10','YYYY-MM-DD'),6500,8300,'BIEN-010');

INSERT INTO SAE_Compteur VALUES 
('COMP-036',26,12,38,'Eau',TO_DATE('2020-02-03','YYYY-MM-DD'),1700,1780,'BIEN-010');

INSERT INTO SAE_Compteur VALUES 
('COMP-037',37,16,53,'Gaz',TO_DATE('2021-09-12','YYYY-MM-DD'),4500,5400,'BIEN-010');

INSERT INTO SAE_Compteur VALUES 
('COMP-038',49,23,72,'Electricite',TO_DATE('2021-04-18','YYYY-MM-DD'),7200,9000,'BIEN-011');

INSERT INTO SAE_Compteur VALUES 
('COMP-039',27,11,38,'Eau',TO_DATE('2019-07-22','YYYY-MM-DD'),2100,2180,'BIEN-011');

INSERT INTO SAE_Compteur VALUES 
('COMP-040',39,17,56,'Gaz',TO_DATE('2020-11-03','YYYY-MM-DD'),5200,6200,'BIEN-011');


INSERT INTO SAE_Compteur VALUES 
('COMP-041',44,19,63,'Electricite',TO_DATE('2020-05-14','YYYY-MM-DD'),6800,8600,'BIEN-012');

INSERT INTO SAE_Compteur VALUES 
('COMP-042',23,10,33,'Eau',TO_DATE('2018-09-11','YYYY-MM-DD'),1600,1680,'BIEN-012');

INSERT INTO SAE_Compteur VALUES 
('COMP-043',35,14,49,'Gaz',TO_DATE('2019-12-07','YYYY-MM-DD'),3900,4700,'BIEN-012');


INSERT INTO SAE_Compteur VALUES 
('COMP-044',51,25,76,'Electricite',TO_DATE('2021-08-29','YYYY-MM-DD'),8400,10200,'BIEN-013');

INSERT INTO SAE_Compteur VALUES 
('COMP-045',28,12,40,'Eau',TO_DATE('2019-01-25','YYYY-MM-DD'),2300,2380,'BIEN-013');

INSERT INTO SAE_Compteur VALUES 
('COMP-046',36,15,51,'Gaz',TO_DATE('2020-03-22','YYYY-MM-DD'),4200,5200,'BIEN-013');


INSERT INTO SAE_Compteur VALUES 
('COMP-047',43,20,63,'Electricite',TO_DATE('2019-12-03','YYYY-MM-DD'),7100,8800,'BIEN-014');

INSERT INTO SAE_Compteur VALUES 
('COMP-048',24,9,33,'Eau',TO_DATE('2020-04-19','YYYY-MM-DD'),1800,1880,'BIEN-014');

INSERT INTO SAE_Compteur VALUES 
('COMP-049',34,13,47,'Gaz',TO_DATE('2018-11-14','YYYY-MM-DD'),3100,4000,'BIEN-014');


INSERT INTO SAE_Compteur VALUES 
('COMP-050',48,22,70,'Electricite',TO_DATE('2021-03-12','YYYY-MM-DD'),7600,9400,'BIEN-015');

INSERT INTO SAE_Compteur VALUES 
('COMP-051',25,11,36,'Eau',TO_DATE('2019-06-07','YYYY-MM-DD'),1950,2030,'BIEN-015');

INSERT INTO SAE_Compteur VALUES 
('COMP-052',37,17,54,'Gaz',TO_DATE('2020-09-09','YYYY-MM-DD'),4700,5600,'BIEN-015');


INSERT INTO SAE_Compteur VALUES 
('COMP-053',46,21,67,'Electricite',TO_DATE('2018-04-30','YYYY-MM-DD'),6400,8100,'BIEN-016');

INSERT INTO SAE_Compteur VALUES 
('COMP-054',22,10,32,'Eau',TO_DATE('2017-10-10','YYYY-MM-DD'),1500,1580,'BIEN-016');

INSERT INTO SAE_Compteur VALUES 
('COMP-055',33,14,47,'Gaz',TO_DATE('2019-05-05','YYYY-MM-DD'),3400,4300,'BIEN-016');


INSERT INTO SAE_Compteur VALUES 
('COMP-056',52,26,78,'Electricite',TO_DATE('2020-12-01','YYYY-MM-DD'),8800,10500,'BIEN-017');

INSERT INTO SAE_Compteur VALUES 
('COMP-057',29,12,41,'Eau',TO_DATE('2019-04-02','YYYY-MM-DD'),2600,2680,'BIEN-017');

INSERT INTO SAE_Compteur VALUES 
('COMP-058',38,16,54,'Gaz',TO_DATE('2021-07-08','YYYY-MM-DD'),5100,6000,'BIEN-017');


INSERT INTO SAE_Compteur VALUES 
('COMP-059',45,20,65,'Electricite',TO_DATE('2021-09-14','YYYY-MM-DD'),7000,8700,'BIEN-018');

INSERT INTO SAE_Compteur VALUES 
('COMP-060',21,9,30,'Eau',TO_DATE('2018-08-08','YYYY-MM-DD'),1400,1480,'BIEN-018');

INSERT INTO SAE_Compteur VALUES 
('COMP-061',31,12,43,'Gaz',TO_DATE('2019-02-28','YYYY-MM-DD'),3200,4100,'BIEN-018');


INSERT INTO SAE_Compteur VALUES 
('COMP-062',49,24,73,'Electricite',TO_DATE('2020-07-07','YYYY-MM-DD'),7800,9600,'BIEN-019');

INSERT INTO SAE_Compteur VALUES 
('COMP-063',27,10,37,'Eau',TO_DATE('2019-10-17','YYYY-MM-DD'),2100,2180,'BIEN-019');

INSERT INTO SAE_Compteur VALUES 
('COMP-064',36,15,51,'Gaz',TO_DATE('2021-02-11','YYYY-MM-DD'),4300,5200,'BIEN-019');


























----------------------------------------------------------------------------------------------------------------
INSERT INTO SAE_Entreprise 
(Numero_Siret, Adresse, Ville, Code_Postale, Nom, Numero_de_Telephone, Specialite)
VALUES ('SIRET001', '15 Rue Tech', 'Paris', '75002', 'TechFix', '0140001122', 'Plomberie');

INSERT INTO SAE_Entreprise 
(Numero_Siret, Adresse, Ville, Code_Postale, Nom, Numero_de_Telephone, Specialite)
VALUES ('SIRET002', '8 Avenue Pro', 'Lyon', '69003', 'ProElec', '0472004455', 'electricite');

INSERT INTO SAE_Entreprise 
(Numero_Siret, Adresse, Ville, Code_Postale, Nom, Numero_de_Telephone, Specialite)
VALUES ('SIRET003', '12 Rue des Roses', 'Marseille', '13005', 'RenoCuisinePro', '0102030407', 'Renovation');

INSERT INTO SAE_Entreprise 
(Numero_Siret, Adresse, Ville, Code_Postale, Nom, Numero_de_Telephone, Specialite)
VALUES ('SIRET004', '10 Rue Nationale', 'Lille', '59000', 'ChaudieresCom', '0102030408', 'Chauffage');

INSERT INTO SAE_Entreprise 
(Numero_Siret, Adresse, Ville, Code_Postale, Nom, Numero_de_Telephone, Specialite)
VALUES ('SIRET005', '18 Avenue du Parc', 'Toulouse', '31000', 'ClimServices', '0102030409', 'Climatisation');

INSERT INTO SAE_Entreprise 
(Numero_Siret, Adresse, Ville, Code_Postale, Nom, Numero_de_Telephone, Specialite)
VALUES ('SIRET006', '33 Rue des ecoles', 'Nice', '06000', 'PeintureDesign', '0102030410', 'Peinture');

























----------------------------------------------------------------------------------------------------------------
INSERT INTO SAE_Facture (Numero_Facture, Montant, Date_de_facture, Compte_Bancaire, Montant_Devis, Date_Paiement, 
 Designation_de_travaux, fk_Id_BienLouable, fk_Numero_Siret)
 VALUES ('FAC-001',350,TO_DATE('2023-03-01','YYYY-MM-DD'),'FR761234567890',300,TO_DATE('2023-03-10','YYYY-MM-DD'),'eéparation plomberie','BIEN-001','SIRET001');

INSERT INTO SAE_Facture (Numero_Facture, Montant, Date_de_facture, Compte_Bancaire, Montant_Devis, Date_Paiement, 
 Designation_de_travaux, fk_Id_BienLouable, fk_Numero_Siret)
 VALUES ('FAC-002',450,TO_DATE('2024-04-01','YYYY-MM-DD'),'FR098765432100',400,TO_DATE('2024-04-12','YYYY-MM-DD'),'Reparation electrique','BIEN-002','SIRET002');

INSERT INTO SAE_Facture (Numero_Facture, Montant, Date_de_facture, Compte_Bancaire, Montant_Devis, Date_Paiement, 
 Designation_de_travaux, fk_Id_BienLouable, fk_Numero_Siret)
 VALUES ('FAC-003',1500,TO_DATE('2023-06-01','YYYY-MM-DD'),'FR230045678901',1450,TO_DATE('2023-06-15','YYYY-MM-DD'),'Renovation cuisine','BIEN-003','SIRET003');

INSERT INTO SAE_Facture (Numero_Facture, Montant, Date_de_facture, Compte_Bancaire, Montant_Devis, Date_Paiement, 
 Designation_de_travaux, fk_Id_BienLouable, fk_Numero_Siret)
 VALUES ('FAC-004',780,TO_DATE('2025-02-18','YYYY-MM-DD'),'FR560123980001',760,TO_DATE('2025-02-25','YYYY-MM-DD'),'Remplacement chaudiere','BIEN-004','SIRET004');

INSERT INTO SAE_Facture (Numero_Facture, Montant, Date_de_facture, Compte_Bancaire, Montant_Devis, Date_Paiement, 
 Designation_de_travaux, fk_Id_BienLouable, fk_Numero_Siret)
 VALUES ('FAC-005',220,TO_DATE('2023-01-14','YYYY-MM-DD'),'FR670098123456',210,TO_DATE('2023-01-20','YYYY-MM-DD'),'Reparation clim','BIEN-005','SIRET005');

INSERT INTO SAE_Facture (Numero_Facture, Montant, Date_de_facture, Compte_Bancaire, Montant_Devis, Date_Paiement, 
 Designation_de_travaux, fk_Id_BienLouable, fk_Numero_Siret)
 VALUES ('FAC-006',950,TO_DATE('2025-05-22','YYYY-MM-DD'),'FR210067009988',900,TO_DATE('2025-05-29','YYYY-MM-DD'),'Travaux peinture','BIEN-006','SIRET006');


INSERT INTO SAE_Facture VALUES 
('FAC-007',180,TO_DATE('2024-07-10','YYYY-MM-DD'),'FR761234567891',160,TO_DATE('2024-07-15','YYYY-MM-DD'),
 'Depannage fuite sous évier','BIEN-001','SIRET001');

INSERT INTO SAE_Facture VALUES
('FAC-008',520,TO_DATE('2025-09-05','YYYY-MM-DD'),'FR761234567892',500,TO_DATE('2025-09-12','YYYY-MM-DD'),
 'Remplacement colonne d évacuation','BIEN-003','SIRET001');


INSERT INTO SAE_Facture VALUES
('FAC-009',260,TO_DATE('2023-06-22','YYYY-MM-DD'),'FR098765432101',240,TO_DATE('2023-06-30','YYYY-MM-DD'),
 'Remplacement disjoncteur','BIEN-002','SIRET002');

INSERT INTO SAE_Facture VALUES
('FAC-010',680,TO_DATE('2024-08-18','YYYY-MM-DD'),'FR098765432102',650,TO_DATE('2024-08-25','YYYY-MM-DD'),
 'Mise aux normes tableau electrique','BIEN-006','SIRET002');


INSERT INTO SAE_Facture VALUES
('FAC-011',2100,TO_DATE('2025-10-01','YYYY-MM-DD'),'FR230045678902',2000,TO_DATE('2025-10-18','YYYY-MM-DD'),
 'Renovation salle de bains','BIEN-003','SIRET003');

INSERT INTO SAE_Facture VALUES
('FAC-012',980,TO_DATE('2025-11-12','YYYY-MM-DD'),'FR230045678903',950,TO_DATE('2025-11-20','YYYY-MM-DD'),
 'Travaux de menuiserie interieure','BIEN-005','SIRET003');


INSERT INTO SAE_Facture VALUES
('FAC-013',320,TO_DATE('2023-03-28','YYYY-MM-DD'),'FR560123980002',300,TO_DATE('2023-04-02','YYYY-MM-DD'),
 'Révision annuelle chaudiere','BIEN-004','SIRET004');

INSERT INTO SAE_Facture VALUES
('FAC-014',1050,TO_DATE('2024-12-01','YYYY-MM-DD'),'FR560123980003',1000,TO_DATE('2024-12-10','YYYY-MM-DD'),
 'Installation radiateurs thermostatiques','BIEN-006','SIRET004');


INSERT INTO SAE_Facture VALUES
('FAC-015',310,TO_DATE('2024-07-02','YYYY-MM-DD'),'FR670098123457',290,TO_DATE('2024-07-08','YYYY-MM-DD'),
 'Recharge gaz clim','BIEN-005','SIRET005');

INSERT INTO SAE_Facture VALUES
('FAC-016',1350,TO_DATE('2023-09-25','YYYY-MM-DD'),'FR670098123458',1300,TO_DATE('2023-10-03','YYYY-MM-DD'),
 'Installation clim split','BIEN-001','SIRET005');


INSERT INTO SAE_Facture VALUES
('FAC-017',480,TO_DATE('2025-04-14','YYYY-MM-DD'),'FR210067009989',450,TO_DATE('2025-04-21','YYYY-MM-DD'),
 'Peinture chambre et salon','BIEN-002','SIRET006');

INSERT INTO SAE_Facture VALUES
('FAC-018',1270,TO_DATE('2025-10-06','YYYY-MM-DD'),'FR210067009990',1200,TO_DATE('2025-10-17','YYYY-MM-DD'),
 'Rafraichissement complet appartement','BIEN-005','SIRET006');






















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

 INSERT INTO SAE_Contrat_Locataire (Id_Locataire, Numero_de_contrat)
 VALUES ('LOC-007','CTR-007');

INSERT INTO SAE_Contrat_Locataire (Id_Locataire, Numero_de_contrat)
 VALUES ('LOC-008','CTR-008');

INSERT INTO SAE_Contrat_Locataire (Id_Locataire, Numero_de_contrat)
 VALUES ('LOC-009','CTR-009');

INSERT INTO SAE_Contrat_Locataire (Id_Locataire, Numero_de_contrat)
 VALUES ('LOC-010','CTR-010');

INSERT INTO SAE_Contrat_Locataire (Id_Locataire, Numero_de_contrat)
 VALUES ('LOC-011','CTR-011');

INSERT INTO SAE_Contrat_Locataire (Id_Locataire, Numero_de_contrat)
 VALUES ('LOC-012','CTR-012');

INSERT INTO SAE_Contrat_Locataire (Id_Locataire, Numero_de_contrat)
 VALUES ('LOC-013','CTR-013');
 
SET AUTOCOMMIT ON;
SHOW AUTOCOMMIT;
