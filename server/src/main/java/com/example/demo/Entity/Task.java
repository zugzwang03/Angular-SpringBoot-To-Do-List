package com.example.demo.Entity;

public class Task {

  private String id;
  private String title;
  private String description;
  private String taskStatus;
  private String date;

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String getTaskStatus() {
    return taskStatus;
  }

  public String getDate() {
    return date;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setTaskStatus(String taskStatus) {
    this.taskStatus = taskStatus;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return (
      "Task is [ id: " +
      id +
      " title: " +
      title +
      " description: " +
      description +
      " task status: " +
      taskStatus +
      " date: " +
      date +
      "];"
    );
  }
}
