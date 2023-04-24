package ru.mch.todo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mch.todo.entity.User;
import ru.mch.todo.service.UserServiceImp;

@AllArgsConstructor
@Controller
@RequestMapping("/users")
public class UserController {

    private UserServiceImp userServiceImp;

    // TODO: 25.04.2023 Поправить задвоенный запрос hibernate после сохранения с модального окна
    @GetMapping("/register")
    public String getRegistrationPage() {
        return "user/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        var savedUser = userServiceImp.add(user);
        if (savedUser.isEmpty()) {
            model.addAttribute("message", "Ошибка создания пользователя");
            return "errors/404";
        }
        return "redirect:/register";
    }
}