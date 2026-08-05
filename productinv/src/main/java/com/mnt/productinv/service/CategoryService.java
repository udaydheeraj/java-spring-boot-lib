package com.mnt.productinv.service;


import com.mnt.productinv.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryService  {

    public List<Category> getAllCategories();

    public void save(Category category);

    Category getCategoryByID(Integer id);

    void delete(Category category);

}
