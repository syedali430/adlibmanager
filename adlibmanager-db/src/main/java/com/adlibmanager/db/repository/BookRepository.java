package com.adlibmanager.db.repository;

import com.adlibmanager.core.domain.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private static final String URL = "jdbc:postgresql://localhost:5432/libdb";
    private static final String USER = "admin";
    private static final String PASSWORD = "password";

    public void save(Book book) {
        String sql = "INSERT INTO books (id, title, author, isbn, available) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, book.getId());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setString(4, book.getIsbn());
            stmt.setBoolean(5, book.isAvailable());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(String id) {
        String sql = "DELETE FROM books WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> search(String keyword) {
        List<Book> results = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE title ILIKE ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Book book = new Book(
                        rs.getString("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("isbn"),
                        rs.getBoolean("available")
                );
                results.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }
}
