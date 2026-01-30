package bm.inventary.controller;

import bm.inventary.entity.Product;
import bm.inventary.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//maneja peticiones http y devuelve JSON  se utiliza en APis REST;
@RestController
//Asocia una URL y metodo HTTP a un controllador o metodo se utiliza a nivel clase o metodo;
@RequestMapping("stock-app")
//se da permisos dependiendo de la peticion y el lenguaje que se utilize si no resiviriamos peticiones de 8080;
@CrossOrigin(value = "http://localhost:4200") // puerto default de angular;
public class ProductController {

//    se manda informacion al loggin de la app
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product") //http://localhost:8080/stock-app/product
    public List<Product> obtainProduct(){

        List<Product> products = this.productService.productList();
        logger.info("Product List:");
        products.forEach(product -> logger.info(product.toString()));
        return products;

    }
    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product){
        logger.info("Product Add", product);
        return this.productService.saveProduct(product);
    }
}
