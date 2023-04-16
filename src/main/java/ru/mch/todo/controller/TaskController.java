package ru.mch.todo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mch.todo.service.TaskServiceImpl;

@Controller
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private TaskServiceImpl taskService;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("tasksList", taskService.findAll());
        return "task/list";
    }

    @GetMapping("/create")
    public String getCreationPage(Model model) {
        model.addAttribute("cities", taskService.findAll());
        return "task/create";
    }
}