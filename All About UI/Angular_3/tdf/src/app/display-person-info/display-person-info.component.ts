import { Component } from '@angular/core';
import { LoggerServiceService } from '../logger-service/logger-service.service';
import { Person } from '../classes/person';
import { Router } from '@angular/router';

@Component({
  selector: 'app-display-person-info',
  templateUrl: './display-person-info.component.html',
  styleUrls: ['./display-person-info.component.css']
})
export class DisplayPersonInfoComponent {
  // peopleselected = '';
  // peopleList = this.loggerService.getPeopleList();
  // peopleListKeys = this.loggerService.getPeopleKeys();
  // keys:string[] = [];
  // constructor(private loggerService:LoggerServiceService,private router:Router) {}
  // navigateTo(person:Person)
  // {
  //   this.router.navigate(['/info/details/' + person.firstname]);
  // }
  // deleteEntry(key:string)
  // {
  //   console.log("Delete ran!");
  //   console.log(this.peopleListKeys[0]);
  //   console.log(this.loggerService.delete(key));
  //   this.router.navigate(['']);
  // }
}
