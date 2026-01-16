CREATE OR REPLACE FUNCTION calcul_solde_tout_compte_locataire (
    p_id_locataire        IN VARCHAR2,
    p_montant_etat_lieux  IN NUMBER -- on demande le montant estimé de l'état des lieux car on ne le stocke pas dans la BD
) RETURN NUMBER
IS
    v_contrat          MSF5131A.SAE_ContratLocation.Numero_de_contrat%TYPE;
    v_loyer_mensuel    MSF5131A.SAE_ContratLocation.Montant_Mensuel%TYPE;
    v_caution          MSF5131A.SAE_ContratLocation.Montant_de_caution%TYPE;

    v_date_calcul      DATE := SYSDATE;
    v_debut_annee      DATE;
    v_fin_annee        DATE;

    v_charges          NUMBER := 0;
    v_total_paye       NUMBER := 0;
    v_loyers_impayes   NUMBER := 0;
    v_prorata          NUMBER := 0;
    v_nb_mois          NUMBER := 0;
BEGIN

    SELECT cl.Numero_de_contrat,
           cl.Montant_Mensuel,
           cl.Montant_de_caution
    INTO   v_contrat,
           v_loyer_mensuel,
           v_caution
    FROM   MSF5131A.SAE_ContratLocation cl,
           MSF5131A.SAE_Contrat_Locataire cll
    WHERE  cl.Numero_de_contrat = cll.Numero_de_contrat
      AND  cll.Id_Locataire = p_id_locataire;

    v_debut_annee := TRUNC(v_date_calcul, 'YYYY');
    v_fin_annee   := ADD_MONTHS(v_debut_annee, 12) - 1;

    v_charges := calcul_regularisation_contrat(
                     TO_NUMBER(TO_CHAR(v_date_calcul, 'YYYY')),
                     v_contrat
                 );

    SELECT NVL(SUM(p.Montant), 0)
    INTO   v_total_paye
    FROM   MSF5131A.SAE_Paiement p
    WHERE  p.fk_Numero_de_contrat = v_contrat
      AND  p.Date_Paiement BETWEEN v_debut_annee AND v_fin_annee;

    v_nb_mois :=
        MONTHS_BETWEEN(
            TRUNC(v_date_calcul, 'MM') + INTERVAL '1' MONTH,
            v_debut_annee
        );

    v_loyers_impayes :=
        (v_nb_mois * v_loyer_mensuel) - v_total_paye;

    -- Si le locataire a trop payé, on considère qu'il na pas d’impayés
    IF v_loyers_impayes < 0 THEN
        v_loyers_impayes := 0;
    END IF;

    v_prorata :=
        (v_loyer_mensuel
         / (LAST_DAY(v_date_calcul) - TRUNC(v_date_calcul, 'MM') + 1))
        * (v_date_calcul - TRUNC(v_date_calcul, 'MM') + 1);

    RETURN
          NVL(v_loyers_impayes, 0)
        + NVL(v_prorata, 0)
        + NVL(v_charges, 0)
        + NVL(p_montant_etat_lieux, 0)
        - NVL(v_caution, 0);

    -- > 0 : le locataire doit payer
    -- < 0 : le propri?taire rembourse

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;
