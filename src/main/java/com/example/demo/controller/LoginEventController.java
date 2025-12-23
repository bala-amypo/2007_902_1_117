package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/logins")
public class LoginEventController {

    @Autowired
    private LoginEventService service;

    @PostMapping("/record")
    public LoginEvent recordLogin(@RequestBody LoginEvent event) {
        return service.recordLogin(event);
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> getEventsByUser(@PathVariable Long userId) {
        return service.getEventsByUser(userId);
    }

    @GetMapping("/suspicious/{userId}")
    public List<LoginEvent> getSuspiciousLogins(@PathVariable Long userId) {
        return service.getSuspiciousLogins(userId);
    }

    @GetMapping("/all")
    public List<LoginEvent> getAllEvents() {
        return service.getAllEvents();
    }
}
