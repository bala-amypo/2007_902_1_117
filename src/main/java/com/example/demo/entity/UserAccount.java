package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String role;

    public String getRole() {
        return role;
    }

    public String getUsername() {
    return username;
}

public String getPassword() {
    return password;
}

    // getters & setters
}
