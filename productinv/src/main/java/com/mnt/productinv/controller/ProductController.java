package com.mnt.productinv.controller;

import com.mnt.productinv.entity.Product;
import com.mnt.productinv.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    List<Product> getAllProducts()
    {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    Product getProductById(@PathVariable int id)
    {
       return productService.findByProductId(id);
    }

    @GetMapping("quantity/{id}")
    List<Product> getByQuantityGreaterThan(@PathVariable int id)
    {
        return productService.findByQuantityGreaterThan(id);
    }


}
