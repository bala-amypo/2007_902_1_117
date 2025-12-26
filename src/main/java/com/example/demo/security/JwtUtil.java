package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public boolean validateToken(String token) {
        return true;
    }

    public String getEmail(String token) {
        return "test@example.com";
    }
}
