package ru.mch.todo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mch.todo.entity.User;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping()
public class IndexController {

    @GetMapping({"/", "/index"})
    public String getIndex(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setName("Гость");
        }
        model.addAttribute("user", user);
        return "index";
    }
}