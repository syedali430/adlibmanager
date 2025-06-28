package com.adlibmanager.core.domain;

import java.time.LocalDate;

public class Member {

    private String id;
    private String name;
    private String email;
    private LocalDate registeredOn;

    public Member(String id, String name, String email, LocalDate registeredOn) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registeredOn = registeredOn;
    }

    // ✅ Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }
}
