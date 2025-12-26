package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LoginEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private boolean success;
    private LocalDateTime timestamp;

    public Long getUserId() {
        return userId;
    }

    public boolean isSuccess() {
        return success;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
