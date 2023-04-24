CREATE TABLE todo_user
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(64),
    login    VARCHAR(64) UNIQUE NOT NULL,
    password VARCHAR(64) UNIQUE NOT NULL
)