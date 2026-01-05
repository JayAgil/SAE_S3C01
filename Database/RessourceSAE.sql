SELECT  table_name
FROM all_tables
WHERE owner = 'MSF5131A';

Select * from MSF5131A.SAE_CHARGES_GENERALE;


-- TOTAL DES PROVISIONS PAYÉES PAR LE LOCATAIRE --
SELECT
    cl.Numero_de_contrat,
    COUNT(p.Id_Paiement) * cl.Provision_Charge AS Total_Provisions
FROM MSF5131A.SAE_Paiement p
JOIN MSF5131A.SAE_ContratLocation cl
    ON p.fk_Numero_de_contrat = cl.Numero_de_contrat
WHERE EXTRACT(YEAR FROM p.Date_Paiement) = 2025
GROUP BY cl.Numero_de_contrat, cl.Provision_Charge;

-- TOTAL DES CHARGES RÉELLES PAYÉES PAR LE PROPRIÉTAIRE --

-- Charges générales
SELECT
    fk_Id_BienLouable,
    SUM(Montant_Total) AS Total_Charges_Generales
FROM MSF5131A.SAE_Charges_Generale
WHERE EXTRACT(YEAR FROM Date_Charge) = 2022
GROUP BY fk_Id_BienLouable;

-- Charges liées aux compteurs (eau, élec, gaz)
SELECT
    fk_Id_BienLouable,
    SUM(Total) AS Total_Compteurs
FROM MSF5131A.SAE_Compteur
GROUP BY fk_Id_BienLouable;

-- Factures (supposées récupérables)
SELECT
    fk_Id_BienLouable,
    SUM(Montant) AS Total_Factures
FROM MSF5131A.SAE_Facture
WHERE EXTRACT(YEAR FROM Date_de_facture) = 2025
GROUP BY fk_Id_BienLouable;

-- TOTAL DES CHARGES RÉELLES (PAR BIEN) --
SELECT
    b.Id_BienLouable,
    NVL(cg.Total_Charges_Generales, 0)
  + NVL(c.Total_Compteurs, 0)
  + NVL(f.Total_Factures, 0) AS Total_Charges_Reelles
FROM MSF5131A.SAE_BienLouable b
LEFT JOIN (
    SELECT fk_Id_BienLouable, SUM(Montant_Total) AS Total_Charges_Generales
    FROM MSF5131A.SAE_Charges_Generale
    WHERE EXTRACT(YEAR FROM Date_Charge) = 2025
    GROUP BY fk_Id_BienLouable
) cg ON b.Id_BienLouable = cg.fk_Id_BienLouable
LEFT JOIN (
    SELECT fk_Id_BienLouable, SUM(Total) AS Total_Compteurs
    FROM MSF5131A.SAE_Compteur
    GROUP BY fk_Id_BienLouable
) c ON b.Id_BienLouable = c.fk_Id_BienLouable
LEFT JOIN (
    SELECT fk_Id_BienLouable, SUM(Montant) AS Total_Factures
    FROM MSF5131A.SAE_Facture
    WHERE EXTRACT(YEAR FROM Date_de_facture) = 2025
    GROUP BY fk_Id_BienLouable
) f ON b.Id_BienLouable = f.fk_Id_BienLouable;


-- RÉGULARISATION DES CHARGES (RÉSULTAT FINAL) --
-- Select Finale
SELECT
    cl.Numero_de_contrat,
    NVL(prov.Total_Provisions, 0) AS Total_Provisions,
    NVL(charges.Total_Charges_Reelles, 0) AS Total_Charges_Reelles,
    NVL(charges.Total_Charges_Reelles, 0)
    - NVL(prov.Total_Provisions, 0) AS Solde_Regularisation
FROM MSF5131A.SAE_ContratLocation cl
LEFT JOIN (
    SELECT
        cl.Numero_de_contrat,
        COUNT(p.Id_Paiement) * cl.Provision_Charge AS Total_Provisions
    FROM MSF5131A.SAE_Paiement p
    JOIN MSF5131A.SAE_ContratLocation cl
        ON p.fk_Numero_de_contrat = cl.Numero_de_contrat
    WHERE EXTRACT(YEAR FROM p.Date_Paiement) = 2023
    GROUP BY cl.Numero_de_contrat, cl.Provision_Charge
) prov ON cl.Numero_de_contrat = prov.Numero_de_contrat
LEFT JOIN (
    SELECT
        b.Id_BienLouable,
        NVL(cg.Total_Charges_Generales, 0)
      + NVL(c.Total_Compteurs, 0)
      + NVL(f.Total_Factures, 0) AS Total_Charges_Reelles
    FROM MSF5131A.SAE_BienLouable b
    LEFT JOIN (
        SELECT fk_Id_BienLouable, SUM(Montant_Total) AS Total_Charges_Generales
        FROM MSF5131A.SAE_Charges_Generale
        WHERE EXTRACT(YEAR FROM Date_Charge) = 2023
        GROUP BY fk_Id_BienLouable
    ) cg ON b.Id_BienLouable = cg.fk_Id_BienLouable
    LEFT JOIN (
        SELECT fk_Id_BienLouable, SUM(Total) AS Total_Compteurs
        FROM MSF5131A.SAE_Compteur
        GROUP BY fk_Id_BienLouable
    ) c ON b.Id_BienLouable = c.fk_Id_BienLouable
    LEFT JOIN (
        SELECT fk_Id_BienLouable, SUM(Montant) AS Total_Factures
        FROM MSF5131A.SAE_Facture
        WHERE EXTRACT(YEAR FROM Date_de_facture) = 2023
        GROUP BY fk_Id_BienLouable
    ) f ON b.Id_BienLouable = f.fk_Id_BienLouable
) charges ON cl.fk_Id_BienLouable = charges.Id_BienLouable
Order by cl.Numero_de_contrat;

-- Solde_Regularisation > 0  -> le locataire doit payer
-- Solde_Regularisation < 0  -> le propriétaire rembourse
-- Solde_Regularisation = 0  -> équilibre

-- sans join
SELECT
    cl.Numero_de_contrat,
    NVL(prov.Total_Provisions, 0) AS Total_Provisions,
    NVL(charges.Total_Charges_Reelles, 0) AS Total_Charges_Reelles,
    NVL(charges.Total_Charges_Reelles, 0)
      - NVL(prov.Total_Provisions, 0) AS Solde_Regularisation
FROM
    MSF5131A.SAE_ContratLocation cl,
    (
        SELECT
            cl2.Numero_de_contrat,
            COUNT(p.Id_Paiement) * cl2.Provision_Charge AS Total_Provisions
        FROM
            MSF5131A.SAE_Paiement p,
            MSF5131A.SAE_ContratLocation cl2
        WHERE
            p.fk_Numero_de_contrat = cl2.Numero_de_contrat
            AND EXTRACT(YEAR FROM p.Date_Paiement) = 2025
        GROUP BY
            cl2.Numero_de_contrat,
            cl2.Provision_Charge
    ) prov,
    (
        SELECT
            b.Id_BienLouable,
            NVL(cg.Total_Charges_Generales, 0)
          + NVL(c.Total_Compteurs, 0)
          + NVL(f.Total_Factures, 0) AS Total_Charges_Reelles
        FROM
            MSF5131A.SAE_BienLouable b,
            (
                SELECT
                    fk_Id_BienLouable,
                    SUM(Montant_Total) AS Total_Charges_Generales
                FROM MSF5131A.SAE_Charges_Generale
                WHERE EXTRACT(YEAR FROM Date_Charge) = 2025
                GROUP BY fk_Id_BienLouable
            ) cg,
            (
                SELECT
                    fk_Id_BienLouable,
                    SUM(Total) AS Total_Compteurs
                FROM MSF5131A.SAE_Compteur
                GROUP BY fk_Id_BienLouable
            ) c,
            (
                SELECT
                    fk_Id_BienLouable,
                    SUM(Montant) AS Total_Factures
                FROM MSF5131A.SAE_Facture
                WHERE EXTRACT(YEAR FROM Date_de_facture) = 2025
                GROUP BY fk_Id_BienLouable
            ) f
        WHERE
            b.Id_BienLouable = cg.fk_Id_BienLouable(+)
            AND b.Id_BienLouable = c.fk_Id_BienLouable(+)
            AND b.Id_BienLouable = f.fk_Id_BienLouable(+)
    ) charges
WHERE
    cl.Numero_de_contrat = prov.Numero_de_contrat(+)
    AND cl.fk_Id_BienLouable = charges.Id_BienLouable(+)
Order by cl.Numero_de_contrat;

SELECT
    cl2.Numero_de_contrat,
    COUNT(p.Id_Paiement) * cl2.Provision_Charge AS Total_Provisions
FROM MSF5131A.SAE_Paiement p, MSF5131A.SAE_ContratLocation cl2
WHERE p.fk_Numero_de_contrat = cl2.Numero_de_contrat
  AND EXTRACT(YEAR FROM p.Date_Paiement) = 2022
GROUP BY cl2.Numero_de_contrat, cl2.Provision_Charge;

SELECT Id_Paiement, Date_Paiement
FROM MSF5131A.SAE_Paiement;

SELECT DISTINCT EXTRACT(YEAR FROM Date_Paiement) AS annee
FROM MSF5131A.SAE_Paiement;