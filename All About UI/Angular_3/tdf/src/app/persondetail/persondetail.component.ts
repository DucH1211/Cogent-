import { Component } from '@angular/core';
import { LoggerServiceService } from '../logger-service/logger-service.service';

@Component({
  selector: 'app-persondetail',
  templateUrl: './persondetail.component.html',
  styleUrls: ['./persondetail.component.css']
})
export class PersondetailComponent {
  constructor(private loggerService:LoggerServiceService){}
  
}
