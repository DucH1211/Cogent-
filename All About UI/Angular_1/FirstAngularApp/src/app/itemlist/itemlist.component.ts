import { Component } from '@angular/core';

@Component({
  selector: 'app-itemlist',
  templateUrl: './itemlist.component.html',
  styleUrls: ['./itemlist.component.css']
})
export class ItemlistComponent {
  recipes =[
    {
      name:'A Test Recipe',
      desc:'This is a simple test',
      image:'',
  },
    {
      name:'A Test Recipe',
      desc:'This is a simple test',
      img:'',
  },
  ]
}
