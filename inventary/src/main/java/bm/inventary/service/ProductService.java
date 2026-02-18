package bm.inventary.service;

import bm.inventary.entity.Product;
import bm.inventary.repository.IRepositoryProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IService {

//    este repositorio no esta activo por lo que no es problema primero lo llena el constructor y despues se utiliza
    private final IRepositoryProduct iRepositoryProduct;

//    no se utiliza autowired ya que puede traer conflictos a futuro
    public ProductService(IRepositoryProduct iRepositoryProduct) {
        this.iRepositoryProduct = iRepositoryProduct;
    }


    @Override
    public List<Product> productList() {
        return this.iRepositoryProduct.findAll();
    }

    @Override
    public Product searchProductID(Integer idProduct) {
        return iRepositoryProduct.findById(idProduct).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        return iRepositoryProduct.save(product);
    }

    @Override
    public void deleteProductID(Integer idProduct) {
        iRepositoryProduct.deleteById(idProduct);
    }

}
