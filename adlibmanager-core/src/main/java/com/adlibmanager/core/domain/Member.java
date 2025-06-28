package com.adlibmanager.core.domain;

import java.time.LocalDate;

public class Member {
    private String id;
    private String name;
    private String email;
    private LocalDate membershipDate;

    public Member(String id, String name, String email, LocalDate membershipDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.membershipDate = membershipDate;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public LocalDate getMembershipDate() { return membershipDate; }
}
