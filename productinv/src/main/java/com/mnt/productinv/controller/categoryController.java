package com.mnt.productinv.controller;

import com.mnt.productinv.entity.Category;
import com.mnt.productinv.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class categoryController {

    private final CategoryService categoryService;

    public categoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories()
    {
        return categoryService.getAllCategories();
    }


}
