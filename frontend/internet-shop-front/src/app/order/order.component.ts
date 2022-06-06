import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {OrderService} from "../service/order.service";
import {LoginService} from "../service/login.service";
import {Product} from "../model/product";
import {Router} from "@angular/router";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit{

  products: Product[] = [];
  status: string = '';
  totalPrice = 0;
  calcPrice = false;

  constructor(private router: Router, private http: HttpClient, private orderService : OrderService , private loginService : LoginService) {
  }

  ngOnInit() {
    this.orderService.getOrder(this.loginService.username).subscribe(data =>
      this.products = data);
  }

  delete(productId : number, orderId : number) {
    this.orderService.delete(productId, orderId, this.loginService.username);
  }

  calcTotalPrice() {
    for(let index in this.products) {
      this.calcPrice = true;
      this.totalPrice = this.totalPrice + this.products[index].price;
    }
  }
}
