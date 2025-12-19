package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class UserAccount {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String employeeId;
private String username;
private String email;
private String password;
private String role;
private String status;
private LocalDateTime createdAt;


public UserAccount() {}


public UserAccount(String employeeId, String username, String email, String password, String role) {
thisemployeeId = employeeId;
this.username = username;
this.email = email;
this.password = password;
this.role = role;
}
@PrePersist
public void onCreate() {
if (status == null) status = "ACTIVE";
createdAt = LocalDateTime.now();
}

// getters and setters
}