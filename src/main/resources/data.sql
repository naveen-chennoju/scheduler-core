DELETE FROM job;

INSERT INTO job (id, name, cron_expression, enabled, next_run_time)
VALUES
  (gen_random_uuid(), 'Job 1', '0 0 * * *', TRUE, '2025-12-01 10:00:00'),
  (gen_random_uuid(), 'Job 2', '0 */5 * * *', TRUE, '2025-12-01 10:05:00'),
  (gen_random_uuid(), 'Job 3', '0 12 * * MON', TRUE, '2025-12-02 12:00:00');
