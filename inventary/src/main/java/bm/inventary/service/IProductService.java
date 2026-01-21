package bm.inventary.service;

import bm.inventary.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> productList();

    Product searchProductID(Integer idProduct);

    void saveProduct(Product product);

    void deleteProductID(Integer idProduct);

}
