package bm.inventary.service;

import bm.inventary.entity.Product;

import java.util.List;

public class ProductService implements IProductService{
    
    @Override
    public List<Product> productList() {
        return List.of();
    }

    @Override
    public Product searchProductID(Integer idProduct) {
        return null;
    }

    @Override
    public void saveProduct(Product product) {

    }

    @Override
    public void deleteProductID(Integer idProduct) {

    }
}
