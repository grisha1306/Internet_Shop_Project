import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private deleteUserUrl = 'http://localhost:8080/deleteUser'

  constructor(private http: HttpClient, private router: Router) {
  }

  getAllUsers(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8080/getAllUsers');
  }

  deleteUser(userId: number) {
    const url = `${this.deleteUserUrl}/${userId}`;
    return this.http.delete(url).subscribe(response => {
      if ( response == true) {
        let currentUrl = this.router.url;
        this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
          this.router.navigate([currentUrl]);
        });
      }
    });
  }

}

