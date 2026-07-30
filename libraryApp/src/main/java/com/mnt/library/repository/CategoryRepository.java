package com.mnt.library.repository;

import com.mnt.library.entity.Category;

import java.util.List;

public interface CategoryRepository {

    void save(Category category);

    Category findById(Integer id);

    List<Category> findAll();

    void update(Category category);

    void deleteById(Category category);



}
