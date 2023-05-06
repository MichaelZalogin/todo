CREATE TABLE priority
(
    id       BIGSERIAL PRIMARY KEY,
    name     TEXT UNIQUE NOT NULL,
    position int
);

INSERT INTO priority (name, position)
VALUES ('urgently', 1),
       ('normal', 2),
       ('not urgent', 3);