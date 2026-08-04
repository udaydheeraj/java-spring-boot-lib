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
       // System.out.println("findbyid : in service triggered");
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public List<Product> findByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> findByPriceLessThan(Double maxPrice) {
        return productRepository.findByPriceLessThan(maxPrice);
    }

    @Override
    public List<Product> findByProductNameContainingIgnoreCase(String keyword) {
        return productRepository.findByProductNameContainingIgnoreCase(keyword);
    }

    @Override
    public List<Product> findByQuantityGreaterThan(Integer minQuantity) {
        return productRepository.findByQuantityGreaterThan(minQuantity);
    }


}
