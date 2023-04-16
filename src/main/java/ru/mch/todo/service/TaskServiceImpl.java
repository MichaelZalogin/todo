package ru.mch.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mch.todo.entity.Task;
import ru.mch.todo.repository.TaskRepository;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Override
    public Task add(Task task) {
        return taskRepository.add(task);
    }

    @Override
    public boolean replace(Long id, Task task) {
        return taskRepository.replace(id, task);
    }

    @Override
    public boolean delete(Long id) {
        return taskRepository.delete(id);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }
}