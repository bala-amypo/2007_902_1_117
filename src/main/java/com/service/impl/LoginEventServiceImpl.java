package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    @Autowired
    private LoginEventRepository repository;

    @Override
    public LoginEvent recordLogin(LoginEvent event) {
        return repository.save(event);
    }

    @Override
    public List<LoginEvent> getEventsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return repository.findByUserIdAndSuspiciousTrue(userId);
    }

    @Override
    public List<LoginEvent> getAllEvents() {
        return repository.findAll();
    }
}
