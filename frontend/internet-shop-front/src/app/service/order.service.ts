import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {OrderModel} from "../model/order-model";
import {Router} from "@angular/router";
import {ProductsService} from "./products.service";
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private orderUrl = 'http://localhost:8080/getOrder';
  private addToOrderUrl = 'http://localhost:8080/addToOrder'
  private deleteProductUrl = 'http://localhost:8080/deleteProduct'

  checkQuantity = false;

  products: Product[] = [];

  constructor(private http: HttpClient, private router: Router, private productsService : ProductsService) { }

  public getOrder(email : string): Observable<any[]> {
    const url = `${this.orderUrl}/${email}`
    return this.http.get<any[]>(url);
  }

  public addToOrder(order : OrderModel) {
    this.http.post(this.addToOrderUrl, order).subscribe(response => {
      if ( response == true ) {
        this.checkQuantity = false;
        let currentUrl = this.router.url;
        this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
          this.router.navigate([currentUrl]);
        });
      }
      else
        this.checkQuantity = true
    });;
  }

  public delete(productId : number, orderId: number, email : string) {
    const url = `${this.deleteProductUrl}/${productId}/${orderId}/${email}`;
    return this.http.delete(url).subscribe(response => {
      if ( response == true) {
        let currentUrl = this.router.url;
        this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
          this.router.navigate([currentUrl]);
        });
      }
    });
  }
}
