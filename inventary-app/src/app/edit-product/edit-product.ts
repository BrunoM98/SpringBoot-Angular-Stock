import { Component, inject, NO_ERRORS_SCHEMA } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product-service';
import { ActivatedRoute } from '@angular/router';
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
  
  ngOnInit(){
    this.id = this.rout.snapshot.params['id'];
    this.productService.obteinProdutID(this.id).subscribe({
      next: (data) => this.product = data,
      error: (errors: any) => console.log(errors)
    }); 
  }

  onSubmit(){
    
  }

}
