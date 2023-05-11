CREATE TABLE IF NOT EXISTS task
(
    id          SERIAL PRIMARY KEY,
    name        TEXT NOT NULL,
    description TEXT,
    created     TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
    done        BOOLEAN,
    user_id     INT  NOT NULL REFERENCES todo_user (id),
    priority_id INT REFERENCES priority (id)
);

INSERT INTO task
    (name, description, created, done, user_id, priority_id)
VALUES ('Task1', 'Description1', NOW(), TRUE, 1, 1),
       ('Task2', 'Description2', NOW(), TRUE, 2, 2),
       ('Task3', 'Description3', NOW(), FALSE, 3, 1),
       ('Task4', 'Description4', NOW(), FALSE, 1, 3),
       ('Task5', 'Description5', NOW(), FALSE, 1, 1);