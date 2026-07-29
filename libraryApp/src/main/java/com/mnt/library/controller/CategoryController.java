package com.mnt.library.controller;

import com.mnt.library.entity.Category;
import com.mnt.library.service.CategoryService;
import com.mnt.library.service.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public void saveCategory(Category category)
    {
        categoryService.save(category);
    }

    @GetMapping("/{id}")
    public Category getCategoryById( @PathVariable Integer id)
    {
        return categoryService.getCatogoryById(id);
    }

    @GetMapping
    public List<Category> getAllCategories()
    {
        return categoryService.findAll();
    }

    @PutMapping("/{id}")
    public void updateCategory(Category category,@PathVariable Integer id)
    {
        categoryService.updateCategory(category,id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Integer id)
    {
        categoryService.deleteById(id);
    }
}
