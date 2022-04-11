import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  // @ts-ignore
  username: String;
  // @ts-ignore
  password: String;
  // @ts-ignore
  confirmPassword: String;


  constructor(private http: HttpClient) {}

  registration(username: string, password: string, confirmPassword : string)  {
    const model = {
      username: username,
      password: password,
      confirmPassword: confirmPassword,
    };

    return this.http.post('http://localhost:8080/registration', model);
  }
}
