package com.app.todoapp;

import com.app.todoapp.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks"; // Ensure this matches the Thymeleaf template name
    }

    @PostMapping
    public String createTask(@RequestParam String title) {
         taskService.createtask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String getTasks(@PathVariable Long id) {
       taskService.deletetask(id);
        return "redirect:/"; // Ensure this matches the Thymeleaf template name
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskService.toogletask(id);
        return "redirect:/";
    }
}
