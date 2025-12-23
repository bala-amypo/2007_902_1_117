package com.example.demo.controller;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.LoginRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/register")
    public UserAccount register(@RequestBody RegisterRequest request) {
        return userAccountService.register(request.getUsername(), request.getEmail(), request.getPassword());
    }

    @PostMapping("/login")
    public UserAccount login(@RequestBody LoginRequest request) {
        return userAccountService.login(request.getEmail(), request.getPassword());
    }
}
