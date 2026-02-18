package bm.inventary.service;

import bm.inventary.entity.Product;

import java.util.List;

public interface IService {

    List<Product> productList();

    Product searchProductID(Integer idProduct);

    Product saveProduct(Product product);

    void deleteProductID(Integer idProduct);

}
