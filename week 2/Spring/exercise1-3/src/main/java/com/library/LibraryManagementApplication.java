package com.library;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class LibraryManagementApplication {

	public static void main(String[] args) {
		 
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Exercise 1-3
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.displayService();
        
	}

}
