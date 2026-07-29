package com.mnt.library.service;

import com.mnt.library.entity.Book;
import com.mnt.library.entity.Category;
import com.mnt.library.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        System.out.println("service");

        return bookRepository.findAll();
    }

    @Override
    public void updateBook(Book book,Integer id) {
       // book.setBookId(id);
        //book.setAuthor(
       // bookRepository.update(book);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {

    }

    @Override
    public List<Book> findBooksByCategory(Integer categoryId) {
        return bookRepository.findBooksByCategory(categoryId);
    }

    @Override
    public List<Book> findBookByCategoryName(String cname) {
        return bookRepository.findBookByCategoryName(cname);
    }

    @Override
    public List<Book> findBooksByPublisher(Integer pId) {
        return bookRepository.findBooksByPublisher(pId);
    }

    @Override
    public List<Book> findBooksByPublisherCity(String cname) {
        return bookRepository.findBooksByPublisherCity(cname);

    }


}
