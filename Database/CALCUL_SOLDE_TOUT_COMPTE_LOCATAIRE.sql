create or replace FUNCTION calcul_solde_tout_compte_locataire (
    p_id_locataire        IN VARCHAR2,
    p_montant_etat_lieux  IN NUMBER
) RETURN NUMBER
IS
    v_contrat          SAE_ContratLocation.Numero_de_contrat%TYPE;
    v_loyer_mensuel    SAE_ContratLocation.Montant_Mensuel%TYPE;
    v_caution          SAE_ContratLocation.Montant_de_caution%TYPE;
    v_date_fin         DATE;
    v_annee            NUMBER;

    v_charges          NUMBER := 0;
    v_total_paye       NUMBER := 0;
    v_loyers_impayes   NUMBER := 0;
    v_prorata          NUMBER := 0;
BEGIN
    ------------------------------------------------------------------
    -- 1. Récupération du contrat du locataire
    ------------------------------------------------------------------
    SELECT cl.Numero_de_contrat,
           cl.Montant_Mensuel,
           cl.Montant_de_caution,
           NVL(cl.Date_Fin, SYSDATE)
    INTO   v_contrat,
           v_loyer_mensuel,
           v_caution,
           v_date_fin
    FROM   SAE_ContratLocation cl
    JOIN   SAE_Contrat_Locataire cll
           ON cl.Numero_de_contrat = cll.Numero_de_contrat
    WHERE  cll.Id_Locataire = p_id_locataire;

    v_annee := EXTRACT(YEAR FROM v_date_fin);

    ------------------------------------------------------------------
    -- 2. Régularisation des charges (année en cours)
    ------------------------------------------------------------------
    v_charges := calcul_regularisation_contrat(v_annee, v_contrat);

    ------------------------------------------------------------------
    -- 3. Loyers impayés (année en cours)
    ------------------------------------------------------------------
    SELECT NVL(SUM(p.Montant), 0)
    INTO   v_total_paye
    FROM   SAE_Paiement p
    WHERE  p.fk_Numero_de_contrat = v_contrat
      AND  EXTRACT(YEAR FROM p.Date_Paiement) = v_annee;

    v_loyers_impayes :=
        (EXTRACT(MONTH FROM v_date_fin) * v_loyer_mensuel)
        - v_total_paye;

    IF v_loyers_impayes < 0 THEN
        v_loyers_impayes := 0;
    END IF;

    ------------------------------------------------------------------
    -- 4. Prorata du dernier mois
    ------------------------------------------------------------------
    v_prorata :=
        (v_loyer_mensuel
         / EXTRACT(DAY FROM LAST_DAY(v_date_fin)))
        * EXTRACT(DAY FROM v_date_fin);

    ------------------------------------------------------------------
    -- 5. Solde final
    ------------------------------------------------------------------
    RETURN
          NVL(v_loyers_impayes, 0)
        + NVL(v_prorata, 0)
        + NVL(v_charges, 0)
        + NVL(p_montant_etat_lieux, 0)
        - NVL(v_caution, 0);

    -- > 0 : le locataire doit payer
    -- < 0 : le propriétaire rembourse

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;