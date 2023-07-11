import { Component, Input, OnInit } from '@angular/core';
import { LoggerServiceService } from '../logger-service/logger-service.service';
import { Student } from '../student';
import { Router } from '@angular/router';

@Component({
  selector: 'app-display-info',
  templateUrl: './display-info.component.html',
  styleUrls: ['./display-info.component.css'],
})
export class DisplayInfoComponent{

  peopleselected = '';
  peopleList = this.loggerService.getPeopleList();
  keys:string[] = [];
  constructor(private loggerService:LoggerServiceService,private router:Router) {}

  navigateTo(id:number)
  {
    this.router.navigate(['/info/details/' + id]);
  }
  onDelete(key:number)
  {
    console.log("Delete ran!");
    console.log(this.loggerService.delete(key));
    this.router.navigate(['']);
  }
  onUpdate(id:number)
  {
    console.log("Update Ran");
    this.navigateTo(id);
  }
}
