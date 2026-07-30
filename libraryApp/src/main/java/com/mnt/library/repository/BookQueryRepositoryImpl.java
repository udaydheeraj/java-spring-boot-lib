package com.mnt.library.repository;

import com.mnt.library.dto.BookCategoryDTO;
import com.mnt.library.dto.BookDetailsDTO;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookQueryRepositoryImpl implements BookQueryRepository {

    private final EntityManager entityManager;

    public BookQueryRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<BookDetailsDTO> getBookDetails() {
        String jpql = "select b.title,b.author,c.categoryName,p.publisherName from Book b join b.category c join b.publisher p ";
        List<BookDetailsDTO> output = entityManager.createQuery(jpql,BookDetailsDTO.class).getResultList();
        int count = output.size();
        System.out.println("total records" + count);
        return output;
    }

    @Override
    public List<BookCategoryDTO> getBooksByCategory(String category) {
      //  String jpql = "select b.title,b.author,c.categoryName from Book b join b.category c where c.categoryName = Lower(:cname)";

        String jpql = "SELECT b.title, b.author, c.categoryName " +
                "FROM Book b " +
                "JOIN b.category c " +
                "WHERE c.categoryName = :categoryName";
        return entityManager.createQuery(jpql,BookCategoryDTO.class).setParameter("categoryName",category).getResultList();
    }
}
