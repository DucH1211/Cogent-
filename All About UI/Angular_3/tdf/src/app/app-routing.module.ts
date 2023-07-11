import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DisplayInfoComponent } from './display-info/display-info.component';
import { AppComponent } from './app.component';
import { PersondetailComponent } from './persondetail/persondetail.component';

const routes: Routes = [
  { path:'',redirectTo:'/home', pathMatch:'full'},
  { path:'home', component: HomeComponent },
  { path:'display-info', component:DisplayInfoComponent},
  { path: 'app', component:AppComponent},
  { path: 'info/details/:id', component:PersondetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
