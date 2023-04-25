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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
            model.addAttribute("message", "Такой пользователь уже существует");
            return "errors/404";
        }
        return "redirect:/tasks";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "user/login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model, HttpServletRequest request) {
        var userOptional = userServiceImp.findByLoginAndPassword(user.getLogin(), user.getPassword());
        if (userOptional.isEmpty()) {
            model.addAttribute("error", "Почта или пароль введены неверно");
            return "user/login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", userOptional.get());
        return "redirect:/tasks";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/users/login";
    }
}