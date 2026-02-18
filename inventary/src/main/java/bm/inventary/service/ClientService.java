package bm.inventary.service;

import bm.inventary.entity.Product;

import java.util.List;

public class ClientService implements IService{

    @Override
    public List<Product> productList() {
        return List.of();
    }

    @Override
    public Product searchProductID(Integer idProduct) {
        return null;
    }

    @Override
    public Product saveProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProductID(Integer idProduct) {

    }
    
}
