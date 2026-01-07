SELECT  table_name
FROM all_tables
WHERE owner = 'MSF5131A';

Select * from MSF5131A.SAE_CHARGES_GENERALE;


-- TOTAL DES PROVISIONS PAY�ES PAR LE LOCATAIRE --
SELECT
    cl.Numero_de_contrat,
    COUNT(p.Id_Paiement) * cl.Provision_Charge AS Total_Provisions
FROM MSF5131A.SAE_Paiement p
JOIN MSF5131A.SAE_ContratLocation cl
    ON p.fk_Numero_de_contrat = cl.Numero_de_contrat
WHERE EXTRACT(YEAR FROM p.Date_Paiement) = 2025
GROUP BY cl.Numero_de_contrat, cl.Provision_Charge;

-- TOTAL DES CHARGES R�ELLES PAY�ES PAR LE PROPRI�TAIRE --

-- Charges g�n�rales
SELECT
    fk_Id_BienLouable,
    SUM(Montant_Total) AS Total_Charges_Generales
FROM MSF5131A.SAE_Charges_Generale
WHERE EXTRACT(YEAR FROM Date_Charge) = 2022
GROUP BY fk_Id_BienLouable;

-- Charges li�es aux compteurs (eau, �lec, gaz)
SELECT
    fk_Id_BienLouable,
    SUM(Total) AS Total_Compteurs
FROM MSF5131A.SAE_Compteur
GROUP BY fk_Id_BienLouable;

-- Factures (suppos�es r�cup�rables)
SELECT
    fk_Id_BienLouable,
    SUM(Montant) AS Total_Factures
FROM MSF5131A.SAE_Facture
WHERE EXTRACT(YEAR FROM Date_de_facture) = 2025
GROUP BY fk_Id_BienLouable;

-- TOTAL DES CHARGES R�ELLES (PAR BIEN) --
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


-- R�GULARISATION DES CHARGES (R�SULTAT FINAL) --
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

-- Select Finale
SELECT
    cl.Numero_de_contrat,
    NVL(prov.Total_Provisions, 0) AS Total_Provisions,
    NVL(charges.Total_Charges_Reelles, 0) AS Total_Charges_Reelles,
    NVL(charges.Total_Charges_Reelles, 0)
    - NVL(prov.Total_Provisions, 0) AS Solde_Regularisation
FROM SAE_ContratLocation cl
LEFT JOIN (
    SELECT
        cl.Numero_de_contrat,
        COUNT(p.Id_Paiement) * cl.Provision_Charge AS Total_Provisions
    FROM SAE_Paiement p
    JOIN SAE_ContratLocation cl
        ON p.fk_Numero_de_contrat = cl.Numero_de_contrat
    WHERE EXTRACT(YEAR FROM p.Date_Paiement) = 2025
    GROUP BY cl.Numero_de_contrat, cl.Provision_Charge
) prov ON cl.Numero_de_contrat = prov.Numero_de_contrat
LEFT JOIN (
    SELECT
        b.Id_BienLouable,
        NVL(cg.Total_Charges_Generales, 0)
      + NVL(c.Total_Compteurs, 0)
      + NVL(f.Total_Factures, 0) AS Total_Charges_Reelles
    FROM SAE_BienLouable b
    LEFT JOIN (
        SELECT fk_Id_BienLouable, SUM(Montant_Total) AS Total_Charges_Generales
        FROM MSF5131A.SAE_Charges_Generale
        WHERE EXTRACT(YEAR FROM Date_Charge) = 2025
        GROUP BY fk_Id_BienLouable
    ) cg ON b.Id_BienLouable = cg.fk_Id_BienLouable
    LEFT JOIN (
        SELECT fk_Id_BienLouable, SUM(Total) AS Total_Compteurs
        FROM SAE_Compteur
        GROUP BY fk_Id_BienLouable
    ) c ON b.Id_BienLouable = c.fk_Id_BienLouable
    LEFT JOIN (
        SELECT fk_Id_BienLouable, SUM(Montant) AS Total_Factures
        FROM SAE_Facture
        WHERE EXTRACT(YEAR FROM Date_de_facture) = 2025
        GROUP BY fk_Id_BienLouable
    ) f ON b.Id_BienLouable = f.fk_Id_BienLouable
) charges ON cl.fk_Id_BienLouable = charges.Id_BienLouable
Order by cl.Numero_de_contrat;


-- Solde_Regularisation > 0  -> le locataire doit payer
-- Solde_Regularisation < 0  -> le propri�taire rembourse
-- Solde_Regularisation = 0  -> �quilibre

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





create or replace FUNCTION calcul_regularisation_contrat (
    p_annee     IN NUMBER,
    p_contrat   IN VARCHAR2
) RETURN NUMBER
IS
    v_total_provisions      NUMBER := 0;
    v_total_charges         NUMBER := 0;
BEGIN

    SELECT NVL(COUNT(p.Id_Paiement) * cl.Provision_Charge, 0)
    INTO v_total_provisions
    FROM MSF5131A.SAE_Paiement p,
         MSF5131A.SAE_ContratLocation cl
    WHERE p.fk_Numero_de_contrat = cl.Numero_de_contrat
      AND cl.Numero_de_contrat = p_contrat
      AND EXTRACT(YEAR FROM p.Date_Paiement) = p_annee
    GROUP BY cl.Provision_Charge;

    SELECT
        NVL(cg.Total_Charges_Generales, 0)
      + NVL(c.Total_Compteurs, 0)
      + NVL(f.Total_Factures, 0)
    INTO v_total_charges
    FROM
        MSF5131A.SAE_ContratLocation cl,
        MSF5131A.SAE_BienLouable b,
        (
            SELECT fk_Id_BienLouable,
                   SUM(Montant_Total) AS Total_Charges_Generales
            FROM MSF5131A.SAE_Charges_Generale
            WHERE EXTRACT(YEAR FROM Date_Charge) = p_annee
            GROUP BY fk_Id_BienLouable
        ) cg,
        (
            SELECT fk_Id_BienLouable,
                   SUM(Total) AS Total_Compteurs
            FROM MSF5131A.SAE_Compteur
            GROUP BY fk_Id_BienLouable
        ) c,
        (
            SELECT fk_Id_BienLouable,
                   SUM(Montant) AS Total_Factures
            FROM MSF5131A.SAE_Facture
            WHERE EXTRACT(YEAR FROM Date_de_facture) = p_annee
            GROUP BY fk_Id_BienLouable
        ) f
    WHERE cl.Numero_de_contrat = p_contrat
      AND cl.fk_Id_BienLouable = b.Id_BienLouable
      AND b.Id_BienLouable = cg.fk_Id_BienLouable(+)
      AND b.Id_BienLouable = c.fk_Id_BienLouable(+)
      AND b.Id_BienLouable = f.fk_Id_BienLouable(+);

    RETURN v_total_charges - v_total_provisions;
    
    -- Solde_Regularisation > 0  -> le locataire doit payer
    -- Solde_Regularisation < 0  -> le propriétaire rembourse
    -- Solde_Regularisation = 0  -> équilibre

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;