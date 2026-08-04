package com.mnt.productinv.repository;

import com.mnt.productinv.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByBrand(String brand);

    List<Product> findByCategory(String category);

    List<Product> findByPriceLessThan(Double maxPrice);

    List<Product> findByProductNameContainingIgnoreCase(String keyword);

    List<Product> findByQuantityGreaterThan(Integer minQuantity);
}
