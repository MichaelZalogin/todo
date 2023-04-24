package ru.mch.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mch.todo.entity.Task;
import ru.mch.todo.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServiceImp implements TaskService {

    private TaskRepository taskRepository;

    @Override
    public Task add(Task task) {
        return taskRepository.add(task);
    }

    @Override
    public boolean update(Task task) {
        return taskRepository.update(task);
    }

    @Override
    public boolean deleteById(Long id) {
        return taskRepository.deleteById(id);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findStatusTasks(boolean status) {
        return taskRepository.findStatusTasks(status);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public boolean updateStatus(Long id, boolean status) {
        return taskRepository.updateStatus(id, status);
    }
}