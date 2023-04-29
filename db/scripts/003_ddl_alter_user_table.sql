ALTER TABLE task
    ADD COLUMN user_id int NOT NULL REFERENCES todo_user (id);