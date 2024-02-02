package com.example.demo.controller;

import com.example.demo.Entity.Task;
import com.example.demo.service.TaskService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
  public Iterable<Task> getTasks() {
    return service.findAllTasks();
  }

  @CrossOrigin(origins = "http://localhost:4200/")
  @RequestMapping("/delete/{id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public String deleteById(@PathVariable("id") String id) {
    service.deleteById(id);
    String jsonResponse = "{\"message\": \"Resource deleted successfully\"}";
    return jsonResponse;
  }

  @CrossOrigin(origins = "http://localhost:4200/")
  @PutMapping("/changeStatus")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public Task changeTaskStatus(
    @RequestBody Task task
  ) {
    return service.changeStatus(task);
  }
}
