import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-servers',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent {
  @Input() ctitle = ""; 
  data = 'ServersComponent Data';
  serverName = 'ABDC';
  selected1 = 'AAA';//default is AAA
  customer: Customers[] = [
  {
    id:23, name:'AAA',
  },
  {
    id:24, name:'BBB'
  },
  {
    id:26, name:'CCC'
  }
]
}
export class Customers{
  id:number = 0;
  name:string = '';
}
