import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { TaskListService } from './task-list.service';
import { TaskListComponent } from './task-list/task-list.component';
import { Task } from './task';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, FormsModule, TaskListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent implements OnInit {
  title = 'Dynamic-to-do-list';
  @Input() newTask: Task = {
    id: "",
    title: "",
    description: "",
    taskStatus: "In Progress",
    date: ""
  };
  taskList: Task[] = [];
  constructor(private taskListService: TaskListService) { }
  ngOnInit() {
    this.taskListService.getTasks().subscribe(res => {
      var taskArray = JSON.parse(JSON.stringify(res));
      if (taskArray.length == 0) {

      }
      else {
        this.taskListService.tasks = taskArray;
        this.taskList = this.taskListService.tasks;
      }
    })
  }
  addItem(): void {
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();

    this.newTask.date = mm + '/' + dd + '/' + yyyy;
    console.log((this.taskList.length).toString());
    this.newTask.id = this.taskList.length.toString();
    if (this.newTask.title == "") {
      alert('Please enter valid task name');
      return;
    }
    this.taskListService.add(this.newTask).subscribe(res => {
      this.taskList.push(JSON.parse(JSON.stringify(res)));
      this.taskListService.tasks = this.taskList;
    });
    this.newTask = {
      id: "",
      title: "",
      description: "",
      taskStatus: "In Progress",
      date: ""
    };
  }
}
