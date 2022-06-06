import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {Product} from "../model/product";
import {ProductsService} from "../service/products.service";
import {LoginService} from "../service/login.service";
import {OrderService} from "../service/order.service";
import {OrderModel} from "../model/order-model";

@Component({
  selector: 'app-all-product',
  templateUrl: './all-product.component.html',
  styleUrls: ['./all-product.component.css']
})
export class AllProductsComponent implements OnInit {

  products: Product[] = [];
  order : OrderModel = {
    email: "", productId: 0
  }

  constructor(private router: Router, private productsService: ProductsService, private loginService: LoginService, private orderService: OrderService) {
  }

  ngOnInit(): void {
    this.productsService.getProducts().subscribe(data => this.products = data);
  }


  authenticated() { return this.loginService.authenticated; }

  checkQuantity() {
    return this.orderService.checkQuantity;
  }

  addToCart(productId: number) {
    const email = this.loginService.username;
    console.log(email);
    this.order  = {email: email, productId: productId}
    this.orderService.addToOrder(this.order);
  }

}
