import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class LoginService {


  authenticated = false;
  username = '';
  password = '';
  role = '';
  noUser = false;

  constructor(private http: HttpClient, private router: Router) {
  }


  authenticate(credentials: { username: any; password: any; }, callback: { (): void; (): any; }) {

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
      }
      // @ts-ignore
      else if (response.user == null) {
        this.noUser = true;
        this.authenticated = false;
      }
      else {
        this.noUser = true;
        this.authenticated = false;
      }

      return callback && callback();
    });

  }

  logout () {
    this.username = '';
    this.authenticated = false;
    this.role = '';
    this.router.navigateByUrl('/logout');
  }

}
