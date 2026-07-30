package com.mnt.library.repository;

import com.mnt.library.dto.BookDetailsDTO;
import com.mnt.library.entity.Book;
import com.mnt.library.entity.Category;

import java.util.List;

public interface BookRepository {
    void save(Book book);

    Book findById(Integer id);

    List<Book> findAll();

    void update(Book book);

    void deleteById(Book book);

    // Relationship Queries

    List<Book> findBooksByCategory(Integer categoryId);

    List<Book> findBookByCategoryName(String cname);

    List<Book> findBooksByPublisher(Integer pId);

    List<Book> findBooksByPublisherCity(String cname);

    List<Book> findBookDetailsWithCategoryAndPublisherById(Integer cpid);



}
