package com.adlibmanager.core.service;

import com.adlibmanager.core.domain.Book;
import java.util.List;

public interface BookService {
    void addBook(Book book);
    void deleteBook(String id);
    List<Book> searchBooks(String query);
}
