import { Component, Input} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  //do not user template and templateUrl together
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'homes';
}
