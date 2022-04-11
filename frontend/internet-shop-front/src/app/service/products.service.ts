import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  private productsUrl = 'http://localhost:8080/products';

  private viewAllSpecUrl = 'http://localhost:8080/infoAboutProduct';

  constructor(private http: HttpClient) { }

  public getProducts(): Observable<any[]> {
    return this.http.get<any[]>(this.productsUrl);
  }

  public viewAllInfoAboutProduct(productId : number) : Observable<any[]> {
    const url = `${this.viewAllSpecUrl}/${productId}`;
    return this.http.get<any[]>(url);
  }


}
