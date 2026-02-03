import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Product } from '../product';
import { ProductService } from '../product-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-product',
  imports: [FormsModule],
  templateUrl: './add-product.html', 
           
})
export class AddProduct {
product: Product = new Product();

private productSrvice = inject(ProductService)

private IRouter = inject(Router);

onSubmit(){
  this.saveProduct();
}

saveProduct(){
    this.productSrvice.addProduct(this.product).subscribe({
      next: (data) => {
        this.goListProduct();
      },
      error: (error:any) => {console.log(error)}
    });
}

goListProduct(){

this.IRouter.navigate(['/products']);
}
}
