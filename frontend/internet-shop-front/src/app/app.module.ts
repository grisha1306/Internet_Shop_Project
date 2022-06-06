import {HTTP_INTERCEPTORS, HttpClientModule, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Injectable, NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import {AllInfoProductComponent} from "./all-info-product/all-info-product.component";
import {LoginComponent} from "./login/login.component";
import {AllProductsComponent} from "./all-product/all-product.component";
import {RegistrationComponent} from "./registration/registration.component";
import {OrderComponent} from "./order/order.component";
import {AllUserComponent} from "./all-user/all-user.component";
import {HttpErrorInterceptor} from "./service/http-interceptor.service";

@NgModule({
  declarations: [
    AppComponent,
    AllInfoProductComponent,
    LoginComponent,
    AllProductsComponent,
    RegistrationComponent,
    OrderComponent,
    AllUserComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpErrorInterceptor,
      multi: true
    }
  ],
  // providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }



