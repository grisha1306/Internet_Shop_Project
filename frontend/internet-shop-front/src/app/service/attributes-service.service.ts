import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Attributes } from '../attributes/attributes.component';

@Injectable({
  providedIn: 'root'
})
export class AttributesService {

  private url = 'http://localhost:8080/attributes/';

  constructor(private http: HttpClient) {
  }

  getAttributes(): Observable<any> {
    return this.http.get(`${this.url}`);
  }

  addAttributes(attribute: Attributes): Observable<Object> {
    return this.http.post(`${this.url}`, attribute);
  }

}
