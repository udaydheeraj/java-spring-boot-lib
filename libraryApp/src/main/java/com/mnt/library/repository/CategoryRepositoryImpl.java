package com.mnt.library.repository;

import com.mnt.library.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Category category) {
        entityManager.persist(category);
    }

    @Override
    public Category findById(Integer id) {
        return entityManager.find(Category.class,id);
    }

    @Override
    public List<Category> findAll() {
        return entityManager.createQuery("From Category",Category.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void update(Category category) {
        entityManager.merge(category);
    }

    @Override
    @Transactional
    public void deleteById(Category category) {
        entityManager.remove(category);
    }


}
