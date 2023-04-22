package ru.mch.todo.controller;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mch.todo.config.exceptions.NotFoundException;
import ru.mch.todo.entity.Task;
import ru.mch.todo.service.TaskService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/task")
public class TaskResource {

    TaskService taskServiceImpl;

    @GetMapping("/{id}")
    public Task getById(@PathVariable long id) {
        return taskServiceImpl.findById(id).orElseThrow(() -> new NotFoundException("Error"));
    }

    @PostMapping("/create")
    public Task createNewTask(@RequestBody Task task) {
        return taskServiceImpl.add(task);
    }

    @PostMapping
    public boolean editTask(@RequestBody Task task) {
        return taskServiceImpl.update(task);
    }

    @GetMapping("/delete/{id}")
    public boolean delete(@PathVariable long id) {
        return taskServiceImpl.deleteById(id);
    }
}