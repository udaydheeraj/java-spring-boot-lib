package com.mnt.library.service;

import com.mnt.library.dto.BookDetailsDTO;
import com.mnt.library.entity.Book;
import com.mnt.library.entity.Category;

import java.util.List;

public interface BookService {
    void save(Book book);

    public Book getBookById(Integer id);

    public List<Book> findAll();

    public void updateBook(Integer id);

    public void deleteById(Integer id);

    public List<Book> findBooksByCategory(Integer categoryId);

    public List<Book> findBookByCategoryName(String cname);

    public List<Book> findBooksByPublisher(Integer pId);

    public List<Book> findBooksByPublisherCity(String cname);

    List<Book> findBookDetailsWithCategoryAndPublisherById(Integer cpid);





}
