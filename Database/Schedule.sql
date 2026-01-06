 
 --A modifier pour update le solde tout compte chaque mois (loyer + charges)
 --Rajouter aussi un pour signaler la fin du contrat de location


CREATE OR REPLACE PROCEDURE MAJ_SOMME_MENSUELLE AS
BEGIN
        UPDATE SAE_ContratLocation
        SET Solde = NVL(Solde, 0) + Montant_Mensuel;
        COMMIT;
END;
/

BEGIN
  MAJ_SOMME_MENSUELLE;
END;
/


BEGIN
  DBMS_SCHEDULER.create_job (
    job_name        => 'JOB_MAJ_SOMME_MENSUELLE',
    job_type        => 'PLSQL_BLOCK',
    job_action      => 'BEGIN MAJ_SOMME_MENSUELLE; END;',
    start_date      => SYSTIMESTAMP,
    repeat_interval => 'FREQ=MONTHLY;BYMONTHDAY=7', 
    enabled         => TRUE
  );
END;
/