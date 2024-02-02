import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, ObservableLike } from 'rxjs';
import { Task } from './task';

@Injectable({
  providedIn: 'root'
})
export class TaskListService {
  tasks: Task[] = [];
  constructor(private http: HttpClient) { }
  add(task: Task): Observable<string> {
    return (this.http.post<string>('http://localhost:8080/tasks', task));
  }
  getTasks(): Observable<string> {
    return this.http.get<string>('http://localhost:8080/tasks');
  }
  deleteTask(id: String): Observable<string> {
    return this.http.get<string>(`http://localhost:8080/tasks/delete/${id}`)
  }
  changeTaskStatus(item: Task): Observable<string> {
    return this.http.put<string>(`http://localhost:8080/tasks/changeStatus`, item);
  }
}
