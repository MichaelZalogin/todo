CREATE TABLE IF NOT EXISTS task
(
    id          SERIAL PRIMARY KEY,
    name        TEXT NOT NULL,
    description TEXT,
    created     TIMESTAMP,
    done        BOOLEAN
);