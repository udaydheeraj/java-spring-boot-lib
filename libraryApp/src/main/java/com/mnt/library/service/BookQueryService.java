package com.mnt.library.service;

import com.mnt.library.dto.BookCategoryDTO;
import com.mnt.library.dto.BookDetailsDTO;

import java.util.List;

public interface BookQueryService {
    public List<BookDetailsDTO> getBookDetails();

    public List<BookCategoryDTO> getBooksByCategory(String category);

    }
