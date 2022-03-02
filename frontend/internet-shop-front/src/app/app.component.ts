import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import { Product } from './model/product';
import { ProductInfo } from './model/product-info';
import { ProductsService } from './service/products.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Internet Shop';
  products: Product[] = [];
  productInfo: ProductInfo[] = [];

  constructor(private router: Router, private productsService: ProductsService) {
  }

  getProducts() {
    this.productsService.getProducts().subscribe(data => {
      this.products = data;
    });
  }

  // viewAllInfoAboutProject(productId : number) {
  //   this.productsService.viewAllInfoAboutProject(productId)
  //     .subscribe(data => this.productInfo = data)
  // }

  // ngOnInit(): void {
  //   this.router.events.subscribe(value => {
  //     this.getProducts();
  //   });
  // }

  ngOnInit(): void {
    this.productsService.getProducts().subscribe(data => this.products = data)
  }
}
