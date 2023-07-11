import { Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Student, country } from '../student';
import { HttpServiceService } from '../http-service/http-service.service';

@Injectable({
  providedIn: 'root'
})
export class LoggerServiceService {
  apptitle = '';
  peopleSelected = '';
  person = new Student();
  peopleList:Student[]=[];
  constructor(private httpService:HttpServiceService) { }
  getLog()
  {
    console.log("Logger");
  }
  addToPeopleList(f:NgForm)
  {
    this.getLog();
    console.log(f.value);
    this.person.firstName = f.value.firstName;
    this.person.lastName = f.value.lastName;
    this.person.email = f.value.email;
    this.httpService.saveUser(this.person).subscribe
    (
      data=>console.log(data),
      error=>console.log('HTTP Error',error),
      ()=>console.log('HTTP Request Completed.'));
  }
  pushPeople()
  {
    return this.httpService.getPeople().subscribe(data=>
      {
        // console.log(data);
        Object.values(data).forEach(student => 
        {
          // console.log(student);
          this.peopleList.push(student);
        })
      });
  }
  delete(id:number)
  {
    return this.httpService.deletePeople(id).subscribe(()=>
      {
        console.log("Delete Success!");
      },
      error => 
      {
        console.log("Delete not Success!",error);
      });
  }
  getPeopleList()
  {
    return this.peopleList;
  }
}
