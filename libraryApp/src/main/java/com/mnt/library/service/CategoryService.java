package com.mnt.library.service;

import com.mnt.library.entity.Category;
import com.mnt.library.entity.Publisher;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    public Category getCatogoryById(Integer id);

    public List<Category> findAll();

    public void updateCategory(Category category, Integer id);

    public void deleteById(Integer id);

    }
