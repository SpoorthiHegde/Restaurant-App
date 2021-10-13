import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../user';
import baseURL from './helper';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  //Injecting HttpClientModule----------------
  constructor(private http: HttpClient) { }

  // ---------------------Add User------------------------------------

  public addUser(user: any) {
    return this.http.post(`${baseURL}/`, user)
  }
  //--------------------login user-----------------------------

  public loginUser(user: any) {
    return this.http.post(`${baseURL}/login`, user)
  }

  //----------------- get user by user name / id-----------------

  public getUserByUserName(userName: string): Observable<User> {
    return this.http.get<User>(`${baseURL}/users/${userName}`);
  }

  public getUserById(userId:number):Observable<User>{
    return this.http.get<User>(`${baseURL}/${userId}`);
  }

  //----------------Update user by user name /id ----------
  public updateUser(userName: string, user: User): Observable<object> {
    return this.http.put(`${baseURL}/users/${userName}`, user);
  }

  public updateUserById(userId:number, user: User): Observable<object> {
    return this.http.put(`${baseURL}/${userId}`, user);
  }
}
