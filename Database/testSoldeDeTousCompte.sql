CREATE OR REPLACE FUNCTION calcul_solde_tout_compte_locataire (
    p_id_locataire        IN VARCHAR2,
    p_montant_etat_lieux  IN NUMBER
) RETURN NUMBER
IS
    v_contrat          SAE_ContratLocation.Numero_de_contrat%TYPE;
    v_loyer_mensuel    SAE_ContratLocation.Montant_Mensuel%TYPE;
    v_caution          SAE_ContratLocation.Montant_de_caution%TYPE;

    v_date_calcul      DATE := SYSDATE;
    v_debut_annee      DATE;
    v_fin_annee        DATE;

    v_charges          NUMBER := 0;
    v_total_paye       NUMBER := 0;
    v_loyers_impayes   NUMBER := 0;
    v_prorata          NUMBER := 0;
    v_nb_mois          NUMBER := 0;
BEGIN
    ------------------------------------------------------------------
    -- 1. Récupération du contrat
    ------------------------------------------------------------------
    SELECT cl.Numero_de_contrat,
           cl.Montant_Mensuel,
           cl.Montant_de_caution
    INTO   v_contrat,
           v_loyer_mensuel,
           v_caution
    FROM   SAE_ContratLocation cl
    JOIN   SAE_Contrat_Locataire cll
           ON cl.Numero_de_contrat = cll.Numero_de_contrat
    WHERE  cll.Id_Locataire = p_id_locataire;

    ------------------------------------------------------------------
    -- 2. Bornes de l’année en cours
    ------------------------------------------------------------------
    v_debut_annee := TRUNC(v_date_calcul, 'YYYY');
    v_fin_annee   := ADD_MONTHS(v_debut_annee, 12) - 1;

    ------------------------------------------------------------------
    -- 3. Régularisation des charges (année en cours)
    ------------------------------------------------------------------
    v_charges := calcul_regularisation_contrat(
                     TO_NUMBER(TO_CHAR(v_date_calcul, 'YYYY')),
                     v_contrat
                 );

    ------------------------------------------------------------------
    -- 4. Total payé sur l’année
    ------------------------------------------------------------------
    SELECT NVL(SUM(p.Montant), 0)
    INTO   v_total_paye
    FROM   SAE_Paiement p
    WHERE  p.fk_Numero_de_contrat = v_contrat
      AND  p.Date_Paiement BETWEEN v_debut_annee AND v_fin_annee;

    ------------------------------------------------------------------
    -- 5. Loyers impayés
    ------------------------------------------------------------------
    v_nb_mois :=
        MONTHS_BETWEEN(
            TRUNC(v_date_calcul, 'MM') + INTERVAL '1' MONTH,
            v_debut_annee
        );

    v_loyers_impayes :=
        (v_nb_mois * v_loyer_mensuel) - v_total_paye;

    IF v_loyers_impayes < 0 THEN
        v_loyers_impayes := 0;
    END IF;

    ------------------------------------------------------------------
    -- 6. Prorata du mois en cours
    ------------------------------------------------------------------
    v_prorata :=
        (v_loyer_mensuel / (LAST_DAY(v_date_calcul) - TRUNC(v_date_calcul, 'MM') + 1))
        * (v_date_calcul - TRUNC(v_date_calcul, 'MM') + 1);

    ------------------------------------------------------------------
    -- 7. Solde final
    ------------------------------------------------------------------
    RETURN
          NVL(v_loyers_impayes, 0)
        + NVL(v_prorata, 0)
        + NVL(v_charges, 0)
        + NVL(p_montant_etat_lieux, 0)
        - NVL(v_caution, 0);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;

SELECT calcul_solde_tout_compte_locataire(
           'LOC-002',
           250
       ) AS solde
FROM dual;

select * from sae_locataire;

CREATE OR REPLACE FUNCTION calcul_solde_tout_compte_locataire_Actif (
    p_id_locataire        IN VARCHAR2,
    p_montant_etat_lieux  IN NUMBER
) RETURN NUMBER
IS
    v_contrat          SAE_ContratLocation.Numero_de_contrat%TYPE;
    v_loyer_mensuel    SAE_ContratLocation.Montant_Mensuel%TYPE;
    v_caution          SAE_ContratLocation.Montant_de_caution%TYPE;

    v_date_calcul      DATE := SYSDATE;
    v_debut_annee      DATE;
    v_fin_annee        DATE;

    v_charges          NUMBER := 0;
    v_total_paye       NUMBER := 0;
    v_loyers_impayes   NUMBER := 0;
    v_prorata          NUMBER := 0;
    v_nb_mois          NUMBER := 0;
BEGIN
    ------------------------------------------------------------------
    -- 1. Récupération du contrat ACTIF du locataire
    ------------------------------------------------------------------
    SELECT cl.Numero_de_contrat,
           cl.Montant_Mensuel,
           cl.Montant_de_caution
    INTO   v_contrat,
           v_loyer_mensuel,
           v_caution
    FROM   SAE_ContratLocation cl,
           SAE_Contrat_Locataire cll
    WHERE  cl.Numero_de_contrat = cll.Numero_de_contrat
      AND  cll.Id_Locataire = p_id_locataire
      AND  (cl.Date_Fin IS NULL OR cl.Date_Fin > SYSDATE);

    ------------------------------------------------------------------
    -- 2. Bornes de l’année en cours
    ------------------------------------------------------------------
    v_debut_annee := TRUNC(v_date_calcul, 'YYYY');
    v_fin_annee   := ADD_MONTHS(v_debut_annee, 12) - 1;

    ------------------------------------------------------------------
    -- 3. Régularisation des charges (année en cours)
    ------------------------------------------------------------------
    v_charges := calcul_regularisation_contrat(
                     TO_NUMBER(TO_CHAR(v_date_calcul, 'YYYY')),
                     v_contrat
                 );

    ------------------------------------------------------------------
    -- 4. Total payé sur l’année
    ------------------------------------------------------------------
    SELECT NVL(SUM(p.Montant), 0)
    INTO   v_total_paye
    FROM   SAE_Paiement p
    WHERE  p.fk_Numero_de_contrat = v_contrat
      AND  p.Date_Paiement BETWEEN v_debut_annee AND v_fin_annee;

    ------------------------------------------------------------------
    -- 5. Loyers impayés
    ------------------------------------------------------------------
    v_nb_mois :=
        MONTHS_BETWEEN(
            TRUNC(v_date_calcul, 'MM') + INTERVAL '1' MONTH,
            v_debut_annee
        );

    v_loyers_impayes :=
        (v_nb_mois * v_loyer_mensuel) - v_total_paye;

    IF v_loyers_impayes < 0 THEN
        v_loyers_impayes := 0;
    END IF;

    ------------------------------------------------------------------
    -- 6. Prorata du mois en cours
    ------------------------------------------------------------------
    v_prorata :=
        (v_loyer_mensuel
         / (LAST_DAY(v_date_calcul) - TRUNC(v_date_calcul, 'MM') + 1))
        * (v_date_calcul - TRUNC(v_date_calcul, 'MM') + 1);

    ------------------------------------------------------------------
    -- 7. Solde final
    ------------------------------------------------------------------
    RETURN
          NVL(v_loyers_impayes, 0)
        + NVL(v_prorata, 0)
        + NVL(v_charges, 0)
        + NVL(p_montant_etat_lieux, 0)
        - NVL(v_caution, 0);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        -- Aucun contrat actif
        RETURN 0;
END;
/
