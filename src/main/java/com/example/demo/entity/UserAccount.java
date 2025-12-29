// package com.example.demo.entity;

// import java.time.LocalDateTime;

// public class UserAccount {

//     private Long id;
//     private String username;
//     private String email;
//     private String password;
//     private String role;
//     private String status;
//     private String employeeId;
//     private LocalDateTime createdAt;

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getUsername() { return username; }
//     public void setUsername(String username) { this.username = username; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }

//     public String getRole() { return role; }
//     public void setRole(String role) { this.role = role; }

//     public String getStatus() { return status; }
//     public void setStatus(String status) { this.status = status; }

//     public String getEmployeeId() { return employeeId; }
//     public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

//     public LocalDateTime getCreatedAt() { return createdAt; }
//     public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
// }


package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.JwtResponse;
import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import com.example.demo.util.JwtUtil;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userAccountService;
    private final JwtUtil jwtUtil;

    public AuthController(UserAccountService userAccountService, JwtUtil jwtUtil) {
        this.userAccountService = userAccountService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        UserAccount user =
                userAccountService.authenticate(request.getUsername(), request.getPassword());

        String token = jwtUtil.generateToken(user.getUsername());
        return new JwtResponse(token);
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody RegisterRequest request) {
        return userAccountService.register(
                request.getUsername(),
                request.getPassword()
        );
    }
}
