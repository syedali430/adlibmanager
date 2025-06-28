package com.adlibmanager.ui;

import com.adlibmanager.core.domain.Book;
import com.adlibmanager.core.service.BookService;
import com.adlibmanager.db.service.BookServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class BookManagerPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private BookService bookService = new BookServiceImpl();

    private JTextField idField, titleField, authorField, isbnField, searchField;
    private JTextArea resultArea;
    private JLabel statusLabel;

    public BookManagerPanel() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        inputPanel.add(authorField);

        inputPanel.add(new JLabel("ISBN:"));
        isbnField = new JTextField();
        inputPanel.add(isbnField);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(this::handleAddBook);
        inputPanel.add(addButton);

        JButton deleteButton = new JButton("Delete by ID");
        deleteButton.addActionListener(this::handleDeleteBook);
        inputPanel.add(deleteButton);

        add(inputPanel, BorderLayout.NORTH);

        searchField = new JTextField();
        searchField.addActionListener(this::handleSearch);
        add(searchField, BorderLayout.CENTER);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.EAST);

        statusLabel = new JLabel(" ");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
    }

    private void handleAddBook(ActionEvent e) {
        Book book = new Book(idField.getText(), titleField.getText(), authorField.getText(), isbnField.getText(), true);
        bookService.addBook(book);
        showMessage("Book added!");
        clearFields();
    }

    private void handleDeleteBook(ActionEvent e) {
        bookService.deleteBook(idField.getText());
        showMessage("Book deleted (if exists).");
        clearFields();
    }

    private void handleSearch(ActionEvent e) {
        List<Book> books = bookService.searchBooks(searchField.getText());
        resultArea.setText("");
        for (Book book : books) {
            resultArea.append(book.getId() + " - " + book.getTitle() + "\n");
        }
        showMessage(books.isEmpty() ? "No books found." : "Search complete.");
    }

    private void showMessage(String msg) {
        statusLabel.setText(msg);
    }

    private void clearFields() {
        idField.setText("");
        titleField.setText("");
        authorField.setText("");
        isbnField.setText("");
        searchField.setText("");
    }
}