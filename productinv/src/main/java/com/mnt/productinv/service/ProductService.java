package com.mnt.productinv.service;

import com.mnt.productinv.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);

    Product findByProductId(int id);

     void delete(Product product);

    List<Product> findByBrand(String brand);

    List<Product> findByCategory(String category);

    List<Product> findByPriceLessThan(Double maxPrice);

    List<Product> findByProductNameContainingIgnoreCase(String keyword);

    List<Product> findByQuantityGreaterThan(Integer minQuantity);
}
