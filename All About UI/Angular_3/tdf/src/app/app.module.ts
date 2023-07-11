import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { DisplayInfoComponent } from './display-info/display-info.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { PersondetailComponent } from './persondetail/persondetail.component';
import { DisplayPersonInfoComponent } from './display-person-info/display-person-info.component';

@NgModule({
  declarations: [
    AppComponent,
    DisplayInfoComponent,
    HomeComponent,
    PersondetailComponent,
    DisplayPersonInfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
