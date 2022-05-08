import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import { Product } from './model/product';
import { ProductInfo } from './model/product-info';
import { ProductsService } from './service/products.service';
import {LoginService} from "./service/login.service";
import {LoginComponent} from "./login/login.component";
import {UserService} from "./service/user.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Internet Shop';
  products: Product[] = [];

  // constructor(private router: Router, private productsService: ProductsService) {
  constructor(private router: Router, private authService : LoginService, private userService : UserService) {
  }

  authenticated() { return this.authService.authenticated; }

  getRole () : boolean{
    if (this.authService.role == "ROLE_ADMIN") {
      return true;
    }

    else {
      return false;
    }
  }

  logout () {
    this.authService.logout();
  }

  toCart() {
    this.router.navigateByUrl('userOrder');
  }

  ngOnInit(): void {
  }
}
