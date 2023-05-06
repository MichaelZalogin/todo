CREATE TABLE todo_user
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(64),
    login    VARCHAR(64) UNIQUE NOT NULL,
    password VARCHAR(64) UNIQUE NOT NULL
);

INSERT INTO todo_user
    (name, login, password)
VALUES ('User1', '1', '1'),
       ('User2', '2', '2'),
       ('User3', '3', '3');