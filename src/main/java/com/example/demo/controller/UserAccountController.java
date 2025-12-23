package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserAccountController {

    @Autowired
    private UserAccountService service;

    @PostMapping("/create")
    public UserAccount createUser(@RequestBody UserAccount user) {
        return service.createUser(user);
    }

    @GetMapping("/{id}")
    public UserAccount getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }
}
