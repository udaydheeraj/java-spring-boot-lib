package com.mnt.productinv.service;

import com.mnt.productinv.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);

    Product findByProductId(int id);
}
