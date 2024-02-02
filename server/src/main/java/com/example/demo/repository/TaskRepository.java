package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.Entity.Task;

public interface TaskRepository extends MongoRepository<Task, String>{
    void deleteById(String id);
}