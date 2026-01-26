import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Product } from './product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProductService {

  private baseURL = "http://localhost:8080/stock-app/product"
  // Inyeccion de dependencias 
  private clientHTTP = inject(HttpClient)

  obteinListProduct(): Observable<Product[]> {
    return this.clientHTTP.get<Product[]>(this.baseURL);
  
}
}
