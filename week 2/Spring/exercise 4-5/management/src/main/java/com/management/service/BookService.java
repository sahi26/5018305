package com.management.service;

import com.management.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter method for Spring to inject BookRepository
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Example method that uses BookRepository
    public void addBook(String bookName) {
        bookRepository.addBook(bookName);
    }
}
