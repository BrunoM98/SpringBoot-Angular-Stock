package bm.inventary.controller;

import bm.inventary.entity.Product;
import bm.inventary.exception.resourcenotfoundException;
import bm.inventary.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//maneja peticiones http y devuelve JSON  se utiliza en APis REST;
@RestController
//Asocia una URL y metodo HTTP a un controllador o metodo se utiliza a nivel clase o metodo;
@RequestMapping("stock-app")
//se da permisos dependiendo de la peticion y el lenguaje que se utilize si no resiviriamos peticiones de 8080;
@CrossOrigin(value = "http://localhost:4200") // puerto default de angular;
public class ProductController {

    //    se manda informacion al loggin de la app
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product") //http://localhost:8080/stock-app/product
    public List<Product> obtainProduct() {

        List<Product> products = this.productService.productList();
        logger.info("Product List:");
        products.forEach(product -> logger.info(product.toString()));
        return products;

    }

    @PostMapping("/product")
//    RequestBody funcion principal atrapar el JSON y transformarlo en un objeto de java para que se pueda compilar
    public Product addProduct(@RequestBody Product product) {
        logger.info("Product Add", product);
        return this.productService.saveProduct(product);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> obtainProductID(
            @PathVariable int id
    ) {
        Product product = this.productService.searchProductID(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            throw new resourcenotfoundException("ID NOT FOUND" + id);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> actProduct(@PathVariable int id, @RequestBody Product productACT) {
//    Buscamos el producto que ya existe
        Product product = this.productService.searchProductID(id);
        if (product == null) {
            return ResponseEntity.notFound().build(); // Devuelve un error 404 limpio
        }
//    Seteamos los nuevos valores del JSON al objeto de la base de datos
        product.setDescription(productACT.getDescription());
        product.setPrice(productACT.getPrice());
        product.setStock(productACT.getStock());
//    Guardamos los datos act
        this.productService.saveProduct(product);
//    Retornamos el objeto act al front como un JSON y decimos que la ejecucion salio bien
        return ResponseEntity.ok(product);
    }
    @DeleteMapping("/product/{id}")
//    Spring lo convierte a JSON automáticamente. Pero cuando borras algo, el producto ya no existe,
//    entonces usamos un Map para crear un JSON "de respuesta" rápido sobre la marcha.
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable int id){
//        Buscamos si existe antes de borrar
        Product product = this.productService.searchProductID(id);
        if (product == null) {
            throw new resourcenotfoundException("ID not found: " + id);
        }
//        Borramos físicamente de la DB
            this.productService.deleteProductID(product.getIdProduct());
//        Angular prefiere objetos.
//        Enviamos un JSON confirmando el borrado
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
    }

}
