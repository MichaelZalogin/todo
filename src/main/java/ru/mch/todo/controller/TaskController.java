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
        return "redirect:/tasks";
    }

    @GetMapping("/completed")
    public String getCompletedTasks(Model model) {
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

    @PostMapping("/update")
    public String updateTask(Model model, @ModelAttribute Task task) {
        var isUpdated = taskServiceImpl.update(task);
        if (!isUpdated) {
            model.addAttribute("message", "Задача с указанным идентификатором не найдена");
            return "errors/404";
        }
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable long id) {
        var isDeleted = taskServiceImpl.deleteById(id);
        if (!isDeleted) {
            model.addAttribute("message", "Задача с указанным идентификатором не найдена");
            return "errors/404";
        }
        return "redirect:/tasks";
    }

    @GetMapping("/updateStatus/{id}/{status}")
    public String updateStatus(@PathVariable long id, @PathVariable boolean status, Model model) {
        var isUpdated = taskServiceImpl.updateStatus(id, status);
        if (!isUpdated) {
            model.addAttribute("message", "Задача с указанным идентификатором не найдена");
            return "errors/404";
        }
        return "redirect:/tasks";
    }
}