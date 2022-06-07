import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {RegistrationService} from "../service/registration.service";
import {LoginService} from "../service/login.service";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  // @ts-ignore
  username: string;
  // @ts-ignore
  password: string;
  // @ts-ignore
  confirmPassword: string;
  errorMessage = '';
  // @ts-ignore
  successMessage: string;
  emailWasFound = false;
  registrationSuccess = false;
  noMatchPassword = false;
  incorrectEmail = false;

  model : any = {
    username: '',
    password: '',
    confirmPassword: '',
  }
  constructor(private router: Router, private regService : RegistrationService, private loginService : LoginService) {}

  ngOnInit(): void {
  }

  registration() {
    this.regService.registration(this.username, this. password, this.confirmPassword).subscribe((result) => {
      this.emailWasFound = false;
      this.registrationSuccess = false;
      this.noMatchPassword = false;
      this.incorrectEmail = false;
      if ( result == 'Ok') {
        this.registrationSuccess = true;
        this.successMessage = 'Login Successful';
        // this.router.navigateByUrl('allProducts')
        let credentials = {username: '', password: ''};
        credentials.password = this.password;
        credentials.username = this.username;
        this.loginService.authenticate(credentials, () => {
          this.router.navigateByUrl('/allProducts');
        });
      }
      else if ( result == 'incorrectPass') {
        this.noMatchPassword = true;
        this.registrationSuccess = false;
        this.errorMessage = 'incorrect password';
      }
      else if ( result == 'IncorrectEmail') {
        this.noMatchPassword = false;
        this.registrationSuccess = false;
        this.incorrectEmail = true;
        this.errorMessage = 'Incorrect email';
      }
      else {
        this.emailWasFound = true;
        this.errorMessage = 'Email was found';
        this.registrationSuccess = false;
      }

    });

  }
}
