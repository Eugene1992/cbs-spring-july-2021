import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Subscription} from "rxjs";
import {TaskService} from "../service/task.service";
import {Task} from "../model/task";

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  private taskId: any;
  public task!: Task;

  constructor(private route: ActivatedRoute,
              private taskService: TaskService) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.taskId = params['id'];
      console.log(this.taskId);
      this.taskService.getTask(this.taskId).subscribe((task: Task) => {
        this.task = task;
      });
    });
  }



}
