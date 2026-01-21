package bm.inventary.repository;

import bm.inventary.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryProduct extends JpaRepository <Product, Integer> {
}
