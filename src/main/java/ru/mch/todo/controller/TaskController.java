package ru.mch.todo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mch.todo.entity.Task;
import ru.mch.todo.service.TaskService;

@Controller
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskServiceImpl;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("tasksList", taskServiceImpl.findAll());
        return "task/list";
    }

    @GetMapping("/create")
    public String getCreationPage() {
        return "task/create";
    }

    @PostMapping("/create")
    public String createNewTask(@ModelAttribute Task task) {
        var savedTask = taskServiceImpl.add(task);
        return "redirect:/";
    }

    @GetMapping("/completed")
    public String getСompletedTasks(Model model) {
        model.addAttribute("completedList", taskServiceImpl.findStatusTasks(true));
        return "task/completedList";
    }

    @GetMapping("/current")
    public String getCurrentTasks(Model model) {
        model.addAttribute("currentList", taskServiceImpl.findStatusTasks(false));
        return "task/currentList";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable long id) {
        var taskOptional = taskServiceImpl.findById(id);
        if (taskOptional.isEmpty()) {
            model.addAttribute("message", "Задача с указанным идентификатором не найдена");
            return "errors/404";
        }
        model.addAttribute("task", taskOptional.get());
        return "task/one";
    }
}