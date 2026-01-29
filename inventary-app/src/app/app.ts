import { Component, signal } from '@angular/core';

import { ProductList } from "./product-list/product-list";

@Component({
  selector: 'app-root',
  imports: [ProductList],
  templateUrl: './app.html'
})
export class App {
  protected readonly title = signal('inventary-app');
}
