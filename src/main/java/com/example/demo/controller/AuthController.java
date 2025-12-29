// package com.example.demo;

// public class AuthController {
//     private final UserAccountService userService;
//     private final JwtUtil jwtUtil;
//     private final PasswordEncoder passwordEncoder;

//     public AuthController(UserAccountService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
//         this.userService = userService;
//         this.jwtUtil = jwtUtil;
//         this.passwordEncoder = passwordEncoder;
//     }

//     public JwtResponse login(LoginRequest request) {
//         UserAccount user = userService.findByUsername(request.getUsernameOrEmail())
//             .orElseGet(() -> userService.findByEmail(request.getUsernameOrEmail()).orElse(null));
        
//         if (user != null && passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//             String token = jwtUtil.generateToken(user.getUsername(), user.getId(), user.getEmail(), user.getRole());
//             return new JwtResponse(token, user.getId(), user.getEmail(), user.getRole());
//         }
        
//         throw new RuntimeException("Invalid credentials");
//     }

//     public UserAccount register(RegisterRequest request) {
//         UserAccount user = new UserAccount();
//         user.setEmployeeId(request.getEmployeeId());
//         user.setUsername(request.getUsername());
//         user.setEmail(request.getEmail());
//         user.setPassword(request.getPassword());
//         user.setRole(request.getRole() != null ? request.getRole() : "USER");
        
//         return userService.createUser(user);
//     }

//     // Simple PasswordEncoder interface
//     public interface PasswordEncoder {
//         String encode(CharSequence rawPassword);
//         boolean matches(CharSequence rawPassword, String encodedPassword);
//     }
// }

package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username,
                                        @RequestParam String password) {

        if ("admin".equals(username) && "admin".equals(password)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid credentials");
        }
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("Auth service alive");
    }
}
