import { Component } from '@angular/core';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent {
  common_ingredients = [
    {
      name: 'Apple',
      amount: 5,
    },
    {
      name:'Tomatoes',
      amount:10,
    }

  ]
}
