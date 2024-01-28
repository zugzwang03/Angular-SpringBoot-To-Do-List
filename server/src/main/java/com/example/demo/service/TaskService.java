package com.example.demo.service;

import com.example.demo.model.Task;
// import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  @Autowired
  private TaskRepository repository;

  public Task addTask(Task task) {
    System.out.println(task);
    return repository.save(task);
  }

  public List<Task> findAllTasks() {
    return repository.findAll();
  }

  // public List<Task> getTaskByName(String taskName) {
  //   return repository.findByTaskName(taskName);
  // }

  public String deleteByTaskname(String taskname) {
    return repository.deleteByTaskname(taskname);
  }
  
}
