CREATE TABLE IF NOT EXISTS task
(
    id          SERIAL PRIMARY KEY,
    description TEXT,
    created     TIMESTAMP,
    done        BOOLEAN
);