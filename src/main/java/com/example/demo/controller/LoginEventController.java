package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/login-events")
public class LoginEventController {

    private final LoginEventService loginService;

    public LoginEventController(LoginEventService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> getUserLoginEvents(@PathVariable Long userId) {
        return loginService.getUserLoginEvents(userId);
    }
}
