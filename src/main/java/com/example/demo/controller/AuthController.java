package com.example.demo.controller;

import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {

        String username = request.get("username");
        String password = request.get("password");

        boolean authenticated = authService.authenticate(username, password);

        if (!authenticated) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String token = jwtUtil.generateToken(username);

        return ResponseEntity.ok(Map.of("token", token));
    }
}
