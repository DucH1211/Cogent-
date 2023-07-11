import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Student } from '../student';
import { Observable,throwError} from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {
  databaseurl = 'https://ngdemo-87857-default-rtdb.firebaseio.com/person/-N_-nUmOWKXErpA1NcHI.json';
  private _databaseurlREST = "http://localhost:8080/api";
  constructor(private http:HttpClient) { }
  
  saveUser(person:Student):Observable<object>
  {
    return this.http.post<Student>(`${this._databaseurlREST}/add-student`,person);
    // return this.http.post('http://localhost:8080/api/add-student',person);
  }
  getPeople():Observable<object>
  {
    return this.http.get<Student[]>(`${this._databaseurlREST}/get-student`);
    //http://localhost:8080/api/get-student
  }
  deletePeople(id:number):Observable<object>
  {
    return this.http.delete(`${this._databaseurlREST}/delete-student/${id}`); 
  }
}
//https://console.firebase.google.com/u/0/project/ngdemo-87857/database/ngdemo-87857-default-rtdb/data/~2F
