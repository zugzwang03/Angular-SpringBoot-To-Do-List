package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService service;

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) {
        return service.addTask(task);
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping
    public List<Task> getTasks() {
        return service.findAllTasks();
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/{taskname}")
    public String deleteByTaskname(@PathVariable("taskname") String taskname) {
        return service.deleteByTaskname(taskname);
    }
}
