package com.mnt.library.repository;

import com.mnt.library.dto.BookCategoryDTO;
import com.mnt.library.dto.BookDetailsDTO;

import java.util.List;

public interface BookQueryRepository {

    public List<BookDetailsDTO> getBookDetails();

     List<BookCategoryDTO> getBooksByCategory(String category);
}

