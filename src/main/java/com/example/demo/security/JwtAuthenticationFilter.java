package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter() {
        this.jwtUtil = new JwtUtil(); // ✅ NO parameters
    }
}
