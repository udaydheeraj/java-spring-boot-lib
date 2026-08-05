package com.mnt.productinv.serviceimpl;

import com.mnt.productinv.entity.Category;
import com.mnt.productinv.repository.CategoryRepository;
import com.mnt.productinv.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public Category getCategoryByID(Integer id) {
        return null;
    }

    @Override
    public void delete(Category category) {

    }
}
