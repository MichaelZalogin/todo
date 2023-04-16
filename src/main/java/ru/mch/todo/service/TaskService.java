package ru.mch.todo.service;

import ru.mch.todo.entity.Task;
import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task add(Task task);

    boolean replace(Long id, Task task);

    boolean delete(Long id);

    List<Task> findAll();

    Optional<Task> findById(Long id);

}