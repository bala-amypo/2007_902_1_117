package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService service;
    private final JwtUtil jwtUtil;

    public AuthController(UserAccountService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return service.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserAccount user) {
        return jwtUtil.generateToken(user.getUsername());
    }
}
