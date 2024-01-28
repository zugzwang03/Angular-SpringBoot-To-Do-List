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
    taskname: ""
  };
  taskList: Task[] = [];
  task: Task = {
    taskname: ""
  };
  constructor(private taskListService: TaskListService) { }
  ngOnInit() {
    this.taskListService.getTasks().subscribe(res => {
      var taskArray = JSON.parse(JSON.stringify(res));
      console.log(taskArray.length);
      if (taskArray.length == 0) {

      }
      else {
        this.taskListService.tasks = taskArray;
        this.taskList = this.taskListService.tasks;
      }
    })
  }
  addItem(): void {
    if (this.newTask.taskname == "") {
      alert('Please enter valid task name');
      return;
    }
    this.taskListService.add(this.newTask).subscribe(res => {
      this.task = JSON.parse(JSON.stringify(res));
      this.taskList.push(this.task);
      this.taskListService.tasks = this.taskList;
    });
    this.newTask = {
      taskname: ""
    };
  }
}
