package com.libmanagement;

import com.libmanagement.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagement {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) context.getBean(BookService.class);

        System.out.println("Spring context loaded and BookService bean retrieved.");
        bookService.addBook("Tacenda");
    }
}
