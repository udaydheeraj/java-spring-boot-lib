package com.mnt.library.controller;

import com.mnt.library.entity.Book;
import com.mnt.library.entity.Category;
import com.mnt.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/category/{categoryId}")
    public List<Book> getBooksByCategory(@PathVariable Integer categoryId)
    {
       return bookService.findBooksByCategory(categoryId);
    }

    @GetMapping("/categoryName/{cname}")
    public List<Book> getBooksByCategoryName(@PathVariable String cname)
    {
        return bookService.findBookByCategoryName(cname);
    }

    @GetMapping("/publisher/{Pid}")
    public List<Book> getBooksByPublisher(@PathVariable Integer Pid)
    {
        return bookService.findBooksByPublisher(Pid);
    }

    @GetMapping("/publisherCity/{cname}")
    public List<Book> getBooksByPublisherCity(@PathVariable String cname)
    {
        return bookService.findBooksByPublisherCity(cname);
    }

    @PostMapping
    public void saveBook(Book book)
    {
        bookService.save(book);
    }

    @GetMapping("/{id}")
    public Book getBookById( @PathVariable Integer id)
    {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks()
    {
        System.out.println("Controller");

        return bookService.findAll();
    }

    @PutMapping("/{id}")
    public void updateBook(Book book,@PathVariable Integer id)
    {
        bookService.updateBook(book,id);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Integer id)
    {
        bookService.deleteById(id);
    }

}
