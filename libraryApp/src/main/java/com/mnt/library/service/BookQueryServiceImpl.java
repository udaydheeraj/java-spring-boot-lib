package com.mnt.library.service;

import com.mnt.library.dto.BookCategoryDTO;
import com.mnt.library.dto.BookDetailsDTO;
import com.mnt.library.repository.BookQueryRepository;
import com.mnt.library.repository.BookQueryRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookQueryServiceImpl implements BookQueryService {
    private final BookQueryRepository bookQueryRepository;

    public BookQueryServiceImpl(BookQueryRepository bookQueryRepository) {
        this.bookQueryRepository = bookQueryRepository;
    }

    public List<BookDetailsDTO> getBookDetails() {
        return bookQueryRepository.getBookDetails();
    }

    @Override
    public List<BookCategoryDTO> getBooksByCategory(String category) {
        return bookQueryRepository.getBooksByCategory(category);
    }
}
