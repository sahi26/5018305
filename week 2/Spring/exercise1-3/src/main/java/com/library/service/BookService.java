package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayService() {
    	//Exercise 1
       System.out.println("BookService is running...");
        //Exercise 2
        if (bookRepository != null) {
            bookRepository.displayRepository();
        } else {
            System.out.println("BookRepository is not injected.");
        }
       
       // bookRepository.displayRepository();
    }
}
