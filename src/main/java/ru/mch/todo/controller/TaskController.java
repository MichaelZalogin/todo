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
}