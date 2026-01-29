import { Component, signal } from '@angular/core';

import { ProductList } from "./product-list/product-list";
import { RouterLink, RouterLinkActive } from "@angular/router";

@Component({
  selector: 'app-root',
  imports: [ProductList, RouterLink, RouterLinkActive],
  templateUrl: './app.html'
})
export class App {
  protected readonly title = signal('inventary-app');
}
