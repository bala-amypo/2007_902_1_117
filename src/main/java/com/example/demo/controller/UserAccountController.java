package com.example.demo;
import org.springframework.http.ResponseEntity;

public class UserAccountController {
    private final UserAccountService userService;

    public UserAccountController(UserAccountService userService) {
        this.userService = userService;
    }

    public ResponseEntity<UserAccount> create(UserAccount user) {
        UserAccount created = userService.createUser(user);
        return ResponseEntity.ok(created);
    }
}