package com.adlibmanager.db.service;

import com.adlibmanager.core.domain.Book;
import com.adlibmanager.core.service.BookService;
import com.adlibmanager.db.repository.BookRepository;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl() {
        this.bookRepository = new BookRepository();
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> searchBooks(String query) {
        return bookRepository.search(query);
    }
}
