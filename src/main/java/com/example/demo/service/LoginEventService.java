package com.example.demo.service;

import com.example.demo.entity.LoginEvent;
import java.util.List;

public interface LoginEventService {

    List<LoginEvent> getUserLoginEvents(Long userId);

    List<LoginEvent> getFailedLogins(Long userId);

    List<LoginEvent> getAllEvents();
}
