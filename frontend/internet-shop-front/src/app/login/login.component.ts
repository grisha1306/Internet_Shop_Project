import {Component, OnInit} from '@angular/core';
import {LoginService} from "../service/login.service";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {

  credentials = {username: '', password: ''};

  constructor(private loginService: LoginService, private http: HttpClient, private router: Router) {
  }

  login() {
    this.loginService.authenticate(this.credentials, () => {
      this.router.navigateByUrl('/allProducts');
    });
    return false;
  }

}

