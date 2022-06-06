// import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpHeaders } from '@angular/common/http';
// import { Injectable } from '@angular/core';
// import { Observable } from 'rxjs';
// import {LoginService} from "./login.service";
//
// @Injectable()
// export class HttpInterceptorService implements HttpInterceptor {
//
//   constructor(private loginService: LoginService) { }
//
//   intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
//     if (this.loginService.isUserLoggedIn() && req.url.indexOf('basicauth') === -1) {
//       const authReq = req.clone({
//         headers: new HttpHeaders({
//           'Content-Type': 'application/json',
//           'Authorization': `Basic ${window.btoa(this.loginService.username + ":" + this.loginService.password)}`
//         })
//       });
//       return next.handle(authReq);
//     } else {
//       return next.handle(req);
//     }
//   }
// }


import {
  HttpEvent, HttpInterceptor, HttpHandler, HttpRequest, HttpResponse, HttpErrorResponse} from '@angular/common/http';

import { Observable, throwError } from 'rxjs';

import { retry, catchError } from 'rxjs/operators';
import {Injectable} from "@angular/core";

@Injectable()
export class HttpErrorInterceptor implements HttpInterceptor {
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(request)
      .pipe(
        // retry(1),
        catchError((error: HttpErrorResponse) => {
          let errorMessage = '';
          if (error.error instanceof ErrorEvent) {
            // client-side error
            errorMessage = `Error: ${error.error.message}`;
          } else {
            // server-side error
            errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
          }
          window.alert(errorMessage);
          return throwError(errorMessage);
        })
      )
  }
}
