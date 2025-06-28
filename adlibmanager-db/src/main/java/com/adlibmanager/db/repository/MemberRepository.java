package com.adlibmanager.db.repository;

import com.adlibmanager.core.domain.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    private static final String URL = "jdbc:postgresql://localhost:5432/libdb";
    private static final String USER = "admin";
    private static final String PASSWORD = "password";

    public void save(Member member) {
        String sql = "INSERT INTO members (id, name, email, registeredon) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, member.getId());
            stmt.setString(2, member.getName());
            stmt.setString(3, member.getEmail());
            stmt.setDate(4, Date.valueOf(member.getRegisteredOn()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(String id) {
        String sql = "DELETE FROM members WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Member> search(String keyword) {
        List<Member> results = new ArrayList<>();
        String sql = "SELECT * FROM members WHERE name ILIKE ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Member member = new Member(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getDate("registeredon").toLocalDate()
                );
                results.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }
}
