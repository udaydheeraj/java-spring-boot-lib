package com.mnt.library.repository;

import com.mnt.library.dto.BookDetailsDTO;
import com.mnt.library.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Book> findBooksByCategory(Integer categoryId) {
        String jpql = "SELECT b FROM Book b WHERE b.category.categoryId = :cid";
        return entityManager.createQuery(jpql,Book.class)
                .setParameter("cid",categoryId).getResultList();
    }

    @Override
    public List<Book> findBookByCategoryName(String cname) {
        String jpql = "SELECT b FROM Book b WHERE b.category.categoryName = :name";
        return entityManager.createQuery(jpql,Book.class)
                .setParameter("name",cname).getResultList();
    }

    @Override
    public List<Book> findBooksByPublisher(Integer pId) {
        String jpql = "SELECT b from Book b WHERE b.publisher.publisherId = :pid";
        return entityManager.createQuery(jpql,Book.class)
                .setParameter("pid",pId).getResultList();
    }

    @Override
    public List<Book> findBooksByPublisherCity(String cname) {
        String jpql = "SELECT b from Book b WHERE b.publisher.city = :pid";
        return entityManager.createQuery(jpql,Book.class)
                .setParameter("pid",cname).getResultList();
    }

    @Override
    public List<Book> findBookDetailsWithCategoryAndPublisherById(Integer cpid) {
        String jpql = "SELECT b FROM Book b JOIN FETCH b.category JOIN FETCH b.publisher WHERE b.bookId = :id";
        return entityManager.createQuery(jpql,Book.class)
                .setParameter("id",cpid).getResultList();
    }



    @Override
    public Book findById(Integer id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> findAll() {
        System.out.println("repo");

        return entityManager.createQuery("From Book", Book.class).getResultList();
    }

    @Override
    @Transactional
    public void update(Book book) {
        entityManager.merge(book);

    }

    @Override
    @Transactional
    public void deleteById(Book book) {
        entityManager.remove(book);
    }



    @Override
    @Transactional
    public void save(Book book) {
      entityManager.persist(book);
    }
}
