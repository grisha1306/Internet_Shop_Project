import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {OrderModel} from "../model/order-model";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private orderUrl = 'http://localhost:8080/getOrder';
  private addToOrderUrl = 'http://localhost:8080/addToOrder'
  private deleteProductUrl = 'http://localhost:8080/deleteProduct'

  checkQuantity = false;

  constructor(private http: HttpClient, private router: Router) { }

  public getOrder(email : string): Observable<any[]> {
    const url = `${this.orderUrl}/${email}`
    return this.http.get<any[]>(url);
  }

  public addToOrder(order : OrderModel) {
    this.http.post(this.addToOrderUrl, order).subscribe(response => {
      if ( response == false )
        this.checkQuantity = true;
      else
        this.checkQuantity = false
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
