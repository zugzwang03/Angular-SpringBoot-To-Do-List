import { Component, Input, OnInit } from '@angular/core';
import { TaskListService } from '../task-list.service';
import { NgFor } from '@angular/common';
import { ItemComponent } from '../item/item.component';
import { Task } from '../task';

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [NgFor, ItemComponent],
  templateUrl: './task-list.component.html',
  styleUrl: './task-list.component.css'
})
export class TaskListComponent {
  @Input() taskList: Task[] = [];
  constructor() { }
}
