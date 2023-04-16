package ru.mch.todo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mch.todo.service.TaskServiceImpl;

@Controller
@AllArgsConstructor
@RequestMapping()
public class IndexController {

    private TaskServiceImpl taskService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("tasksList", taskService.findAll());
        return "index";
    }
}