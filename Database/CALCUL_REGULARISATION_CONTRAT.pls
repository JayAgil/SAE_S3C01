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

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;