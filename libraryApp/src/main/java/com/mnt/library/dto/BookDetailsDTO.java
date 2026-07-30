package com.mnt.library.dto;

public class BookDetailsDTO {

    private String bookName;

    private String author;

    private String categoryName;

    private String publisherName;

    public BookDetailsDTO() {
    }

    public BookDetailsDTO(String bookName, String author, String categoryName, String publisherName) {
        this.bookName = bookName;
        this.author = author;
        this.categoryName = categoryName;
        this.publisherName = publisherName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}
