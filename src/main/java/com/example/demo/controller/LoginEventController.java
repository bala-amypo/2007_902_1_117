package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login-events")
public class LoginEventController {

    private final LoginEventService loginService;

    public LoginEventController(LoginEventService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public void recordLogin(@RequestBody LoginEvent event) {
        loginService.recordLogin(event);
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> getUserEvent(@PathVariable Long userId) {
        return loginService.getUserLoginEvent(userId);
    }
}
