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

  constructor(private router: Router, private http: HttpClient, private orderService : OrderService , private loginService : LoginService) {
  }

  ngOnInit() {
    this.orderService.getOrder(this.loginService.username).subscribe(data => this.products = data);
  }

  delete(productId : number) {
    this.orderService.delete(productId, this.loginService.username).subscribe(() => this.status = 'Delete successful');
    if ( this.status == 'Delete successful')
      this.router.navigateByUrl('/userOrder');
  }

}
