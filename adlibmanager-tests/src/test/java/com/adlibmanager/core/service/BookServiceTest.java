package com.adlibmanager.core.service;

import com.adlibmanager.core.domain.Book;
import com.adlibmanager.db.service.BookServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService;

    @Before
    public void setUp() {
        // ✅ Import implementation from db module
        bookService = new BookServiceImpl();
    }

    @Test
    public void shouldAddBookAndFindIt() {
        Book book = new Book("1", "Java 8 Basics", "John Doe", "ISBN123", true);
        bookService.addBook(book);

        List<Book> results = bookService.searchBooks("Java");
        assertEquals(1, results.size());
        assertEquals("Java 8 Basics", results.get(0).getTitle());
    }

    @Test
    public void shouldDeleteBookById() {
        Book book = new Book("2", "Clean Code", "Uncle Bob", "ISBN456", true);
        bookService.addBook(book);
        bookService.deleteBook("2");

        List<Book> results = bookService.searchBooks("Clean");
        assertEquals(0, results.size());
    }
}
