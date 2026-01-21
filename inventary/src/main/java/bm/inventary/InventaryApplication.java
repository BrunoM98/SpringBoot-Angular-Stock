package bm.inventary;

import bm.inventary.entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventaryApplication.class, args);

        Product product = new Product();
        product.setDescription("Camisa M");
        product.setPrice(600.0);
        product.setStock(50);

        System.out.println(product);
	}

}
