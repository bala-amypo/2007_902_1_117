package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> request) {

        String username = request.get("username");
        String email = request.get("email");
        String password = request.get("password");

        return "User registered successfully: " + username;
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> request) {

        String username = request.get("username");
        String password = request.get("password");

        return "Login successful for user: " + username;
    }
}
