import { Component, Input } from '@angular/core';
import { TaskListService } from '../../../../client/src/app/task-list.service';
import { Task } from '../../../../client/src/app/task';

@Component({
  selector: 'app-item',
  standalone: true,
  imports: [],
  templateUrl: './item.component.html',
  styleUrl: './item.component.css'
})
export class ItemComponent {
  @Input() item: Task = {
    id: "",
    title: "",
    description: "",
    taskStatus: "",
    date: ""
  };
  constructor(private taskListService: TaskListService) {

  }
  removeTask() {
    var index = this.taskListService.tasks.indexOf(this.item);
    this.taskListService.tasks.splice(index, 1);
    this.taskListService.deleteTask(this.item.id).subscribe(res =>
      console.log(res));
  }

  taskDone() {
    this.item.taskStatus = "Done";
    this.taskListService.changeTaskStatus(this.item).subscribe(res => {
      console.log(res);
    });
  }
}