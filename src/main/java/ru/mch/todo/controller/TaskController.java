package ru.mch.todo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mch.todo.entity.Priority;
import ru.mch.todo.exceptions.NotFoundException;
import ru.mch.todo.entity.Task;
import ru.mch.todo.entity.User;
import ru.mch.todo.service.CategoryService;
import ru.mch.todo.service.PriorityService;
import ru.mch.todo.service.TaskService;

@Controller
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskServiceImp;

    private PriorityService priorityServiceImp;

//    private CategoryService categoryServiceImp;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("tasksList", taskServiceImp.findAllOrderById());
        return "task/list";
    }

    @GetMapping("/create")
    public String getCreationPage(Model model) {
        model.addAttribute("priorities", priorityServiceImp.findAll());
//        model.addAttribute("categories", categoryServiceImp.findAll());
        return "task/create";
    }

    @PostMapping("/create")
    public String createNewTask(@ModelAttribute Task task, @SessionAttribute User user) {
        task.setUser(user);
        var savedTask = taskServiceImp.add(task);
        return "redirect:/tasks";
    }

    @GetMapping("/completed")
    public String getCompletedTasks(Model model) {
        model.addAttribute("completedList", taskServiceImp.findStatusTasks(true));
        return "task/completedList";
    }

    @GetMapping("/current")
    public String getCurrentTasks(Model model) {
        model.addAttribute("currentList", taskServiceImp.findStatusTasks(false));
        return "task/currentList";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Task getById(@PathVariable long id, Model model) {
        return taskServiceImp.findById(id).orElseThrow(() -> new NotFoundException("Error"));
    }

    @PostMapping("/update")
    public String updateTask(@RequestBody Task task, @SessionAttribute User user) {
        task.setUser(user);
        taskServiceImp.update(task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        taskServiceImp.deleteById(id);
        return "redirect:/tasks";
    }

    @GetMapping("/updateStatus/{id}/{status}")
    public String updateStatus(@PathVariable long id, @PathVariable boolean status, Model model) {
        taskServiceImp.updateStatus(id, status);
        return "redirect:/tasks";
    }
}