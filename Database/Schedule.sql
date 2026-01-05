 
 --A modifier pour update le solde tout compte chaque mois (loyer + charges)
 --Rajouter aussi un pour signaler la fin du contrat de location
  DBMS_SCHEDULER.create_job (
    job_name        => 'UPDATE_BONUS_MONTHLY',
    job_type        => 'PLSQL_BLOCK',
    job_action      => q'[
      BEGIN
        UPDATE employee
        SET bonus = bonus * 1.10;
        COMMIT;
      END;
    ]',
    start_date      => TRUNC(ADD_MONTHS(SYSDATE, 1), 'MM'),
    repeat_interval => 'FREQ=MONTHLY; BYMONTHDAY=1',
    enabled         => TRUE
  );
END;
/


-- Ou alors ça


BEGIN
  DBMS_SCHEDULER.create_program(
  program_name => 'plsql_program',
  program_type => 'PLSQL_BLOCK',    
  program_action => 'BEGIN DBMS_STATS.gather_schema_stats(''HR''); END;',
  enabled => TRUE,
  comments => 'Program to gather HR user statistics');
  DBMS_SCHEDULER.enable (name=>'plsql_program');
END;
/