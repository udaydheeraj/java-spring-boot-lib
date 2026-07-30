package com.mnt.library.controller;

import com.mnt.library.dto.BookCategoryDTO;
import com.mnt.library.dto.BookDetailsDTO;
import com.mnt.library.service.BookQueryService;
import com.mnt.library.service.BookQueryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookQueryController {

    private final BookQueryService bookQueryService;

    public BookQueryController(BookQueryService bookQueryService) {
        this.bookQueryService = bookQueryService;
    }

    @GetMapping("/details")
    public List<BookDetailsDTO> getBookDetails()
    {
        return   bookQueryService.getBookDetails();
    }

    @GetMapping("/category/{categoryName}")
    public List<BookCategoryDTO> getBooksByCategory(@PathVariable String categoryName)
    {
        return bookQueryService.getBooksByCategory(categoryName);
    }


}
