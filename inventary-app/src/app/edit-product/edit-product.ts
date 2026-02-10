import { Component, inject, NO_ERRORS_SCHEMA } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product-service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit-product',
  imports: [FormsModule],
  templateUrl: './edit-product.html',
})
export class EditProduct {

  product: Product = new Product();
  id!: number;

  private productService = inject(ProductService);
  private rout = inject(ActivatedRoute);
  private router = inject(Router);
  
  ngOnInit(){
    this.id = this.rout.snapshot.params['id'];
    this.productService.obteinProdutID(this.id).subscribe({
      next: (data) => this.product = data,
      error: (errors: any) => console.log(errors)
    }); 
  }

  onSubmit(){
    this.saveProduct();
  }

  saveProduct(){
    this.productService.editProduct(this.id, this.product).subscribe({
      next: (data) => this.goProductList(),
      error: (errors) => console.log(errors)
      
    });
  }

  goProductList(){
    this.router.navigate(['/products']);
  }

}
