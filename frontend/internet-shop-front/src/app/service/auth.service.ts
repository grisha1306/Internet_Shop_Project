import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import {LoginComponent} from "../login/login.component";

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  authenticated = false;
  username = '';
  role = '';

  constructor(private http: HttpClient) {
  }

  // @ts-ignore
  authenticate(credentials, callback) {

    this.username = credentials.username;
    const headers = new HttpHeaders(credentials ? {
      authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});

    this.http.get('http://localhost:8080/login', {headers: headers}).subscribe(response => {
      // @ts-ignore
      if (response['name']) {
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
  }

}
