package com.adlibmanager.ui;

import com.adlibmanager.core.domain.Member;
import com.adlibmanager.core.service.MemberService;
import com.adlibmanager.core.service.MemberServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;

public class MemberManagerPanel extends JPanel {
	private static final long serialVersionUID = 1L;

    private MemberService memberService = new MemberServiceImpl();

    private JTextField idField, nameField, emailField, searchField;
    private JTextArea resultArea;

    public MemberManagerPanel() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        JButton addButton = new JButton("Add Member");
        addButton.addActionListener(this::handleAddMember);
        inputPanel.add(addButton);

        JButton deleteButton = new JButton("Delete by ID");
        deleteButton.addActionListener(this::handleDeleteMember);
        inputPanel.add(deleteButton);

        add(inputPanel, BorderLayout.NORTH);

        searchField = new JTextField();
        searchField.addActionListener(this::handleSearch);
        add(searchField, BorderLayout.CENTER);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.SOUTH);
    }

    private void handleAddMember(ActionEvent e) {
        Member member = new Member(
                idField.getText(),
                nameField.getText(),
                emailField.getText(),
                LocalDate.now()
        );
        memberService.addMember(member);
        showMessage("Member added!");
        clearFields();
    }

    private void handleDeleteMember(ActionEvent e) {
        memberService.deleteMember(idField.getText());
        showMessage("Member deleted (if exists).");
        clearFields();
    }

    private void handleSearch(ActionEvent e) {
        List<Member> members = memberService.searchMembers(searchField.getText());
        resultArea.setText("");
        for (Member member : members) {
            resultArea.append(member.getId() + " - " + member.getName() + "\n");
        }
    }

    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        emailField.setText("");
    }
}
