import { Component, inject, OnInit, signal } from '@angular/core'; // <--- Añadimos signal
import { Product } from '../product';
import { ProductService } from '../product-service';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './product-list.html'
})
export class ProductList implements OnInit {
  
  // 1. Ahora es un Signal. Esto "avisa" al HTML automáticamente.
  products = signal<Product[]>([]); 

  private productService = inject(ProductService);
  private IRouter = inject(Router);

  ngOnInit() {
    this.obteinProduct();
  }

  private obteinProduct(): void {
    this.productService.obteinListProduct().subscribe({
      next: (data) => {
        console.log("¡Llegaron los datos!", data);
        // 2. Para actualizar un signal usamos .set()
        this.products.set(data); 
      },
      error: (error) => console.error("Error al obtener datos:", error)
    });
  }
   editProduct(id:number){
    this.IRouter.navigate(['edit-product', id]);
  }
}
