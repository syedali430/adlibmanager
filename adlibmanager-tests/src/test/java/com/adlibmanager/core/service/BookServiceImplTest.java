package com.adlibmanager.core.service;

import com.adlibmanager.core.domain.Book;
import com.adlibmanager.db.service.BookServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookServiceImplTest {

    private BookService bookService;

    @Before
    public void setUp() {
        bookService = new BookServiceImpl();
    }

    @Test
    public void shouldAddAndRetrieveBook() {
        Book book = new Book("test-101", "JUnit for Java", "Test Author", "ISBN-JUNIT", true);
        bookService.addBook(book);

        List<Book> found = bookService.searchBooks("JUnit");
        assertFalse(found.isEmpty());
        assertEquals("JUnit for Java", found.get(0).getTitle());
    }

    @Test
    public void shouldDeleteBookById() {
        Book book = new Book("test-102", "Delete Me", "Nobody", "ISBN-DEL", true);
        bookService.addBook(book);
        bookService.deleteBook("test-102");

        List<Book> found = bookService.searchBooks("Delete Me");
        assertTrue(found.isEmpty());
    }
}