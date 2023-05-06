CREATE TABLE task_category
(
    id       BIGSERIAL PRIMARY KEY,
    task     INT NOT NULL REFERENCES task (id),
    category int NOT NULL REFERENCES category (id),
    UNIQUE (task, category)
);

INSERT INTO task_category
    (task, category)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (2, 1),
       (3, 3),
       (3, 1),
       (4, 1),
       (4, 3),
       (5, 2),
       (5, 1);






