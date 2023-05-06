CREATE TABLE category
(
    id   BIGSERIAL PRIMARY KEY,
    name TEXT UNIQUE NOT NULL
);

INSERT INTO category
    (name)
VALUES ('shop'),
       ('home'),
       ('university');