// noinspection AngularMissingOrInvalidDeclarationInModule

import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { ProductInfo } from "../model/product-info";
import { ProductsService } from "../service/products.service";

// noinspection AngularMissingOrInvalidDeclarationInModule
@Component({
  selector: 'all-info-product',
  templateUrl: './all-info-product.component.html',
  styleUrls: ['./all-info-product.component.css']
})

export class AllInfoProductComponent implements OnInit {

  // @ts-ignore
  productInfo: ProductInfo[] = [];

  constructor(private router: Router, private productService: ProductsService) {
  }

  getUrlWithoutParams() : number {
    const urlTree = this.router.parseUrl(this.router.url);
    // console.log(urlTree);
    const urlParam = urlTree.root.children['primary'].segments[1].path;
    // console.log(urlParam);
    return parseInt(urlParam);
  }

  ngOnInit() {
    console.log(this.getUrlWithoutParams());
    // console.log(this.router.url);
    this.productService.viewAllInfoAboutProduct(this.getUrlWithoutParams()).subscribe(data => this.productInfo = data);
  }

}
