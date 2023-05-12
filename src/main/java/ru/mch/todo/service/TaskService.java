package ru.mch.todo.service;

import ru.mch.todo.entity.Task;
import ru.mch.todo.entity.User;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task add(Task task);

    void update(Task task);

    void deleteById(Long id);

    List<Task> findAllOrderById();

    List<Task> findStatusTasks(boolean status);

    Optional<Task> findById(Long id);

    void updateStatus(Long id, boolean status);

    List<Task> findAllWithTimeZone(User user);

}