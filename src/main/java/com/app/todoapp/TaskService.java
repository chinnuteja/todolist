package com.app.todoapp;

import com.app.todoapp.models.Task;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createtask(String title) {
        Task task=new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);

    }

    public void deletetask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toogletask(Long id) {
       Task task=taskRepository.findById(id)
               .orElseThrow(()-> new IllegalArgumentException(("Invalid task id")));
       task.setCompleted(!task.isCompleted());
       taskRepository.save(task);
    }
}
