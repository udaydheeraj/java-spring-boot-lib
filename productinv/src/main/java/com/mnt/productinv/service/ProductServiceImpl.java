package com.mnt.productinv.service;

import com.mnt.productinv.entity.Product;
import com.mnt.productinv.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {

        return productRepository.findAll();
    }

    public void save(Product product){
        productRepository.save(product);
        System.out.println("product Saved  " + product.getProductId());
    }

    @Override
    public Product findByProductId(int id) {

        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
