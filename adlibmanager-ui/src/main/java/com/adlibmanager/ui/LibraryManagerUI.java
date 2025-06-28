package com.adlibmanager.ui;

import javax.swing.*;

public class LibraryManagerUI extends JFrame {
    private static final long serialVersionUID = 1L;

    public LibraryManagerUI() {
        setTitle("Library Manager");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Books", new BookManagerPanel());
        tabs.add("Members", new MemberManagerPanel());

        add(tabs);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryManagerUI().setVisible(true));
    }
}
