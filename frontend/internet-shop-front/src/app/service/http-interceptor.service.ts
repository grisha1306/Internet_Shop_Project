import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {LoginService} from "./login.service";

@Injectable()
export class HttpInterceptorService implements HttpInterceptor {

  constructor(private loginService: LoginService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.loginService.isUserLoggedIn() && req.url.indexOf('basicauth') === -1) {
      const authReq = req.clone({
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Authorization': `Basic ${window.btoa(this.loginService.username + ":" + this.loginService.password)}`
        })
      });
      return next.handle(authReq);
    } else {
      return next.handle(req);
    }
  }
}

// import {Injectable} from "@angular/core";
// import {HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from "@angular/common/http";
// import {LoginService} from "./auth.service";
// import {Observable} from "rxjs";
//
// @Injectable()
// export class HttpInterceptorService implements HttpInterceptor {
//
//   constructor(private authService: LoginService) { }
//
//   intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
//     if (this.authService.isUserLoggedin() && req.url.indexOf('basicauth') === -1) {
//       const request = req.clone({
//         headers: new HttpHeaders({
//           'Content-Type': 'application/json',
//           'Authorization': `Basic ${window.btoa(this.authService.username + ":" + this.authService.password)}`
//         })
//       });
//       return next.handle(request);
//     }
//
//     return next.handle(req);
//   }
// }
