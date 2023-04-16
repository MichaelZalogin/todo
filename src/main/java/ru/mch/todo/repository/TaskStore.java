package ru.mch.todo.repository;

import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.mch.todo.entity.Task;
import java.util.List;

@Repository
@AllArgsConstructor
public class TaskStore implements Store<Long, Task> {

    private final SessionFactory sf;

    @Override
    public Task add(Task task) {
        return null;
    }

    @Override
    public boolean replace(Long id, Task task) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Task> findAll() {
        return null;
    }

    @Override
    public List<Task> findByName(String key) {
        return null;
    }

    @Override
    public Task findById(Long id) {
        return null;
    }
}