-- Insertion SAE_Garant
INSERT INTO SAE_Garant (Nom, Adresse, Tel) VALUES ('Dupont', '12 Rue de Paris, 75001 Paris', '0145789632');
INSERT INTO SAE_Garant (Nom, Adresse, Tel) VALUES ('Martin', '5 Avenue Victor Hugo, 75016 Paris', '0154789632');

-- Insertion SAE_Batiment
INSERT INTO SAE_Batiment (Adresse, Date_construction) VALUES ('10 Rue Lafayette, 75009 Paris', TO_DATE('2000-06-15', 'YYYY-MM-DD'));
INSERT INTO SAE_Batiment (Adresse, Date_construction) VALUES ('20 Boulevard Haussmann, 75008 Paris', TO_DATE('1995-09-20', 'YYYY-MM-DD'));

-- Insertion SAE_BienLouable
INSERT INTO SAE_BienLouable (NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, Id_BienLouable_2, fk_Adresse_Bat)
VALUES ('FR123456789', '10 Rue Lafayette, 75009 Paris', 75, 3, 'Appartement', NULL, '10 Rue Lafayette, 75009 Paris');

INSERT INTO SAE_BienLouable (NumeroFiscale, Adresse, Surface_d_habituable, Nombre_de_pieces, Type_bien_louable, Id_BienLouable_2, fk_Adresse_Bat)
VALUES ('FR987654321', '20 Boulevard Haussmann, 75008 Paris', 120, 5, 'Maison', NULL, '20 Boulevard Haussmann, 75008 Paris');

-- Insertion SAE_Locataire
INSERT INTO SAE_Locataire (Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, Lieu_de_naissance, Salaire, Profession, Situation_Familiale, Image_Locataire, fk_Id_Garant)
VALUES ('Durand', 'Jean', '5 Rue de Lyon, 75012 Paris', '0165987452', 'jean.durand@example.com', '75012', 'Paris', TO_DATE('1985-03-10','YYYY-MM-DD'), 'Paris', 3500, 'Ingénieur', 'Marié', NULL, 1);

INSERT INTO SAE_Locataire (Nom, Prenom, Adresse, Tel, Email, Code_Postale, Ville, Date_de_naissance, Lieu_de_naissance, Salaire, Profession, Situation_Familiale, Image_Locataire, fk_Id_Garant)
VALUES ('Moreau', 'Sophie', '8 Rue de Lille, 75007 Paris', '0175981234', 'sophie.moreau@example.com', '75007', 'Paris', TO_DATE('1990-07-22','YYYY-MM-DD'), 'Paris', 2800, 'Professeur', 'Célibataire', NULL, 2);

-- Insertion SAE_ContratLocation
INSERT INTO SAE_ContratLocation (Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel, Date_versement, Index_Compteur_Eau, Index_Compteur_Electrcite, Index_Compteur_Gaz, fk_Id_BienLouable)
VALUES (TO_DATE('2023-01-01','YYYY-MM-DD'), TO_DATE('2023-12-31','YYYY-MM-DD'), 1500, 100, 0, 1200, TO_DATE('2023-01-01','YYYY-MM-DD'), 120, 340, 200, 1);

INSERT INTO SAE_ContratLocation (Date_debut, Date_Fin, Montant_de_caution, Provision_Charge, Solde, Montant_Mensuel, Date_versement, Index_Compteur_Eau, Index_Compteur_Electrcite, Index_Compteur_Gaz, fk_Id_BienLouable)
VALUES (TO_DATE('2023-02-01','YYYY-MM-DD'), TO_DATE('2024-01-31','YYYY-MM-DD'), 2000, 150, 0, 2000, TO_DATE('2023-02-01','YYYY-MM-DD'), 150, 400, 250, 2);

-- SAE_Contrat_Locataire
INSERT INTO SAE_Contrat_Locataire (Id_Locataire, Numero_de_contrat) VALUES (1, 1);
INSERT INTO SAE_Contrat_Locataire (Id_Locataire, Numero_de_contrat) VALUES (2, 2);

-- SAE_Charges_Generale
INSERT INTO SAE_Charges_Generale (Type_Charge, Montant_Caution, Pourcentage, Quotite, fk_Id_BienLouable)
VALUES ('Electricité', 100, 50, 1.0, 1);

INSERT INTO SAE_Charges_Generale (Type_Charge, Montant_Caution, Pourcentage, Quotite, fk_Id_BienLouable)
VALUES ('Eau', 50, 25, 0.5, 2);

-- SAE_Paiement
INSERT INTO SAE_Paiement (Montant, Date_Paiement, fk_Numero_de_contrat) VALUES (1200, TO_DATE('2023-01-05','YYYY-MM-DD'), 1);
INSERT INTO SAE_Paiement (Montant, Date_Paiement, fk_Numero_de_contrat) VALUES (2000, TO_DATE('2023-02-05','YYYY-MM-DD'), 2);

-- SAE_Entreprise
INSERT INTO SAE_Entreprise (Numero_Siret, Adresse, Ville, Code_Postale, Nom, Numero_de_Telephone, Specialite)
VALUES ('12345678901234', '50 Rue Saint Denis, 75001 Paris', 'Paris', '75001', 'Bâtiments SARL', '0145123456', 'Construction');

-- SAE_Facture
INSERT INTO SAE_Facture (Montant, Date_de_facture, Compte_Bancaire, Montant_Devis, Date_Paiement, Designation_de_travaux, fk_Id_BienLouable, fk_Numero_Siret)
VALUES (5000, TO_DATE('2023-03-01','YYYY-MM-DD'), 'FR7630004000031234567890143', 4500, TO_DATE('2023-03-10','YYYY-MM-DD'), 'Rénovation', 1, '12345678901234');

-- SAE_IRL
INSERT INTO SAE_IRL (Annee, IRL) VALUES (2023, 1.85);

-- SAE_Assurance
INSERT INTO SAE_Assurance (Prime, Montant, Type_assurance, Agence, Adresse_agence, Tel_agence, fk_Adresse)
VALUES (500, 10000, 'Multirisque', 'AXA', '12 Rue de Paris, 75001 Paris', '0145789632', '10 Rue Lafayette, 75009 Paris');

-- SAE_Compteur
INSERT INTO SAE_Compteur (Partie_Fixe, Partie_Variable, Total, TypeCompteur, Date_Installation, Index_ancien, Index_nouveau, fk_Id_BienLouable)
VALUES (15, 0.20, 35, 'Eau', TO_DATE('2022-01-01','YYYY-MM-DD'), 100, 120, 1);

-- SAE_Diagnostics
INSERT INTO SAE_Diagnostics (Type_Diagnostic, Date_Realisation, Date_Validite, Fichier, fk_Id_BienLouable)
VALUES ('Amiante', TO_DATE('2023-01-01','YYYY-MM-DD'), TO_DATE('2033-01-01','YYYY-MM-DD'), NULL, 1);