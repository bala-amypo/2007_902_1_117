package com.example.demo;

import java.util.List;

public interface LoginEventService {
    LoginEvent recordLogin(LoginEvent event);
    List<LoginEvent> getEventsByUser(Long userId);
    List<LoginEvent> getSuspiciousLogins(Long userId);
}