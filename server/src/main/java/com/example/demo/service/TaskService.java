package com.example.demo.service;

import com.example.demo.Entity.Task;
import com.example.demo.repository.TaskRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  @Autowired
  private TaskRepository repository;

  public Task addTask(Task task) {
    return repository.save(task);
  }

  public Iterable<Task> findAllTasks() {
    return repository.findAll();
  }

  // public List<Task> getTaskByName(String taskName) {
  //   return repository.findByTaskName(taskName);
  // }

  public void deleteById(String id) {
    repository.deleteById(id);
  }

  public Task changeStatus(Task task) {
    return repository.save(task);
  }
}
