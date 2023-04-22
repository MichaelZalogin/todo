package ru.mch.todo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class IndexController {

    @GetMapping({"/", "/index"})
    public String getIndex() {
        return "index";
    }
}