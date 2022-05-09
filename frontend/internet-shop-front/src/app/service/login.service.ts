import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {


  authenticated = false;
  username = '';
  password = '';
  role = '';

  constructor(private http: HttpClient) {
  }

  // @ts-ignore
  authenticate(credentials, callback) {

    this.username = credentials.username;
    this.password = credentials.password;
    const headers = new HttpHeaders(credentials ? {
      authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});

    this.http.get('http://localhost:8080/login', {headers: headers}).subscribe(response => {
      // @ts-ignore
      if (response.authenticated == true) {
        this.authenticated = true;
        // @ts-ignore
        this.role = response.authorities[0].authority;
      } else {
        this.authenticated = false;
      }

      return callback && callback();
    });

  }

  logout () {
    this.username = '';
    this.authenticated = false;
    this.role = '';
    this.http.get('http://localhost:8080/logout').subscribe(response => {
    });
  }

  isUserLoggedIn() : boolean {
    if (this.username != '')
      return true;
    else
      return false;
  }
}
