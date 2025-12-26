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
        user.setRole("USER");
        user.setStatus("ACTIVE");
        return service.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserAccount request) {
        UserAccount user = service.getByUsername(request.getUsername());

        return jwtUtil.generateToken(
                user.getUsername(),
                user.getId(),
                user.getRole(),
                user.getStatus()
        );
    }
}
