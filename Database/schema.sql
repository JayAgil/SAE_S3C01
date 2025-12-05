-- Oracle SQL Schema (suivant exactement le modèle fourni)

CREATE TABLE SAE_Garant (
    Id_Garant VARCHAR2(50) PRIMARY KEY,
    Nom VARCHAR2(50),
    Prenom VARCHAR2(50),
    Adresse VARCHAR2(50),
    Tel VARCHAR2(14)
);

CREATE TABLE SAE_Batiment (
    Adresse VARCHAR2(50) PRIMARY KEY,
    Date_construction DATE
);

CREATE TABLE SAE_BienLouable (
    Id_BienLouable VARCHAR2(50) PRIMARY KEY,
    NumeroFiscale VARCHAR2(50),
    Adresse VARCHAR2(50),
    Surface_d_habituable NUMBER,
    Nombre_de_pieces NUMBER,
    Type_bien_louable VARCHAR2(50),
    Id_BienLouable_2 NUMBER,
    fk_Adresse_Bat VARCHAR2(50),
    CONSTRAINT fk_bien_bat FOREIGN KEY (fk_Adresse_Bat) REFERENCES SAE_Batiment(Adresse)
);

CREATE TABLE SAE_Locataire (
    Id_Locataire VARCHAR2(50) PRIMARY KEY,
    Nom VARCHAR2(50),
    Prenom VARCHAR2(50),
    Adresse VARCHAR2(50),
    Tel VARCHAR2(14),
    Email VARCHAR2(50),
    Code_Postale VARCHAR2(50),
    Ville VARCHAR2(50),
    Date_de_naissance DATE,
    Lieu_de_naissance VARCHAR2(50),
    Salaire NUMBER,
    Profession VARCHAR2(50),
    Situation_Familiale VARCHAR2(50),
    Image_Locataire VARCHAR2(50),
    fk_Id_Garant VARCHAR2(50),
    CONSTRAINT fk_loc_garant FOREIGN KEY (fk_Id_Garant) REFERENCES SAE_Garant(Id_Garant)
);

CREATE TABLE SAE_ContratLocation (
    Numero_de_contrat VARCHAR2(50) PRIMARY KEY,
    Date_debut DATE,
    Date_Fin DATE,
    Montant_de_caution NUMBER,
    Provision_Charge NUMBER,
    Solde NUMBER,
    Montant_Mensuel NUMBER,
    Date_versement DATE,
    Index_Compteur_Eau NUMBER,
    Index_Compteur_Electrcite NUMBER,
    Index_Compteur_Gaz NUMBER,
    fk_Id_BienLouable VARCHAR2(50),
    CONSTRAINT fk_contrat_bien FOREIGN KEY (fk_Id_BienLouable) REFERENCES SAE_BienLouable(Id_BienLouable)
);

CREATE TABLE SAE_Charges_Generale (
    Id_Charges_Generale VARCHAR2(50) PRIMARY KEY,
    Type_Charge VARCHAR2(50),
    Montant_Total NUMBER,
    Pourcentage NUMBER,
    Quotite NUMBER(3,1),
    Mois VARCHAR (15), 
    fk_Id_BienLouable VARCHAR2(50),
    CONSTRAINT fk_chg_bien FOREIGN KEY (fk_Id_BienLouable) REFERENCES SAE_BienLouable(Id_BienLouable)
);

CREATE TABLE SAE_Diagnostics (
    Id_Diagnostics VARCHAR2(50) PRIMARY KEY,
    Type_Diagnostic VARCHAR2(50),
    Date_Realisation DATE,
    Date_Validite DATE,
    Fichier VARCHAR2(50), 
    fk_Id_BienLouable VARCHAR(50),
    CONSTRAINT fk_diag_bien FOREIGN KEY (fk_Id_BienLouable) REFERENCES SAE_BienLouable(Id_BienLouable)
);

CREATE TABLE SAE_IRL (
    Annee NUMBER PRIMARY KEY,
    IRL NUMBER
);

CREATE TABLE SAE_Paiement (
    Id_Paiement VARCHAR2(50) PRIMARY KEY,
    Montant NUMBER,
    Date_Paiement DATE,
    fk_Numero_de_contrat VARCHAR2(50),
    CONSTRAINT fk_paiement_contrat FOREIGN KEY (fk_Numero_de_contrat) REFERENCES SAE_ContratLocation(Numero_de_contrat)
);

CREATE TABLE SAE_Entreprise (
    Numero_Siret VARCHAR2(50) PRIMARY KEY,
    Adresse VARCHAR2(50),
    Ville VARCHAR2(50),
    Code_Postale VARCHAR2(50),
    Nom VARCHAR2(50),
    Numero_de_Telephone VARCHAR2(14),
    Specialite VARCHAR2(50)
);

CREATE TABLE SAE_Assurance (
    Numero_d_assurance VARCHAR2(50) PRIMARY KEY,
    Prime NUMBER,
    Montant NUMBER,
    Type_assurance VARCHAR2(50),
    Agence VARCHAR2(50),
    Adresse_agence VARCHAR2(50),
    Tel_agence VARCHAR2(50),
    fk_Adresse VARCHAR2(50),
    CONSTRAINT fk_assur_bat FOREIGN KEY (fk_Adresse) REFERENCES SAE_Batiment(Adresse)
);

CREATE TABLE SAE_Compteur (
    Id_Compteur VARCHAR2(50) PRIMARY KEY,
    Partie_Fixe NUMBER,
    Partie_Variable NUMBER,
    Total NUMBER,
    TypeCompteur VARCHAR2(50),
    Date_Installation DATE,
    Index_ancien NUMBER,
    Index_nouveau NUMBER,
    fk_Id_BienLouable VARCHAR2(50),
    CONSTRAINT fk_comp_bien FOREIGN KEY (fk_Id_BienLouable) REFERENCES SAE_BienLouable(Id_BienLouable)
);

CREATE TABLE SAE_Facture (
    Numero_Facture VARCHAR2(50) PRIMARY KEY,
    Montant NUMBER,
    Date_de_facture DATE,
    Compte_Bancaire VARCHAR2(50),
    Montant_Devis NUMBER,
    Date_Paiement DATE,
    Designation_de_travaux VARCHAR2(50),
    fk_Id_BienLouable VARCHAR2(50),
    fk_Numero_Siret VARCHAR2(50),
    CONSTRAINT fk_fact_bien FOREIGN KEY (fk_Id_BienLouable) REFERENCES SAE_BienLouable(Id_BienLouable),
    CONSTRAINT fk_fact_ent FOREIGN KEY (fk_Numero_Siret) REFERENCES SAE_Entreprise(Numero_Siret)
);

CREATE TABLE SAE_Contrat_Locataire (
    Id_Locataire VARCHAR2(50),
    Numero_de_contrat VARCHAR2(50),
    PRIMARY KEY (Id_Locataire, Numero_de_contrat),
    CONSTRAINT fk_cl_loc FOREIGN KEY (Id_Locataire) REFERENCES SAE_Locataire(Id_Locataire),
    CONSTRAINT fk_cl_con FOREIGN KEY (Numero_de_contrat) REFERENCES SAE_ContratLocation(Numero_de_contrat)
);
