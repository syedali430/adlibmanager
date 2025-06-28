package com.adlibmanager.core.domain;

public class Book {
    private String id;
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    public Book(String id, String title, String author, String isbn, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = available;
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return available; }

    // Setters
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
