package com.mnt.library.repository;

import com.mnt.library.entity.Category;
import com.mnt.library.entity.Publisher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PublisherRepositoryImpl implements PublisherRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Publisher publisher) {
        entityManager.persist(publisher);
    }

    @Override
    public Publisher findById(Integer id) {
        return entityManager.find(Publisher.class,id);
    }

    @Override
    public List<Publisher> findAll() {
        return entityManager.createQuery("From Publisher",Publisher.class).getResultList();
    }

    @Override
    public void update(Publisher publisher) {
        entityManager.merge(publisher);
    }

    @Override
    public void deleteById(Publisher publisher) {
        entityManager.remove(publisher);
    }
}
