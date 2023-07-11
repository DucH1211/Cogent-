import { Component, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms'
import { LoggerServiceService } from './logger-service/logger-service.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[LoggerServiceService]
  //using this will create one instance of provider 
  //for each component, do not do this without @Injectable instead.
})
export class AppComponent implements OnInit{
  constructor(private loggerService:LoggerServiceService){};
  title = 'tdf';
  ngOnInit(): void {
    console.log("This display ran!");
    console.log(this.loggerService.pushPeople()); 
  }
}