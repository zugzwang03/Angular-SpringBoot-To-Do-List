package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Task;

public interface TaskRepository extends MongoRepository<Task, String>{
    List<Task> findByTaskname(String taskname);
    String deleteByTaskname(String taskname);
}