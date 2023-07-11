import { Component } from '@angular/core';
import { LoggerServiceService } from '../logger-service/logger-service.service';
import { NgForm } from '@angular/forms';
import { HttpServiceService } from '../http-service/http-service.service';
import { Student } from '../student';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  // loggerService:LoggerServiceService;
  title = 'tdf';
  // countryList = this.loggerService.getCountryList();
  constructor(private loggerService:LoggerServiceService,private httpService:HttpServiceService) {
    loggerService.apptitle = this.title;
  }
  onSubmit(f:NgForm)
  {
    if(!f.valid)
      return false;
    else{
      this.loggerService.addToPeopleList(f);
      return true;
    }
  }
}
