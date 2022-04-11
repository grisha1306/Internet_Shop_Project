import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {OrderModel} from "../model/order-model";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private orderUrl = 'http://localhost:8080/getOrder';
  private addToOrderUrl = 'http://localhost:8080/addToOrder'
  private deleteProductUrl = 'http://localhost:8080/deleteProduct'

  constructor(private http: HttpClient) { }

  public getOrder(email : string): Observable<any[]> {
    const url = `${this.orderUrl}/${email}`
    return this.http.get<any[]>(url);
  }

  public addToOrder(order : OrderModel) {
    this.http.post(this.addToOrderUrl, order).subscribe(response => {
    });;
  }

  public delete(productId : number, email : string) {
    const url = `${this.deleteProductUrl}/${productId}/${email}`;
    return this.http.delete(url);
  }
}
