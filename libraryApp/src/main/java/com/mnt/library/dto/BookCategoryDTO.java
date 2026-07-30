package com.mnt.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookCategoryDTO {
    String bookTitle;
    String author;
    String publisherName;


}
