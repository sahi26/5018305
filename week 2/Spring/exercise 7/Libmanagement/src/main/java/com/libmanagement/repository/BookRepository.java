package com.libmanagement.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void addBook(String bookName) {
        System.out.println("Adding book: " + bookName);
    }
}
