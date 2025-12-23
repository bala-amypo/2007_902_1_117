package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository repo;
    private final RuleEvaluationUtil ruleEvaluator;

    public LoginEventServiceImpl(LoginEventRepository repo,
                                 RuleEvaluationUtil ruleEvaluator) {
        this.repo = repo;
        this.ruleEvaluator = ruleEvaluator;
    }

    @Override
    public LoginEvent recordLogin(LoginEvent event) {
        if (event.getIpAddress() == null || event.getDeviceId() == null) {
            throw new IllegalArgumentException("IP address and device ID required");
        }

        if (event.getTimestamp() == null) {
            event.setTimestamp(LocalDateTime.now());
        }

        LoginEvent saved = repo.save(event);
        ruleEvaluator.evaluateLoginEvent(saved);

        return saved;
    }

    @Override
    public List<LoginEvent> getEventsByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return repo.findByUserIdAndLoginStatus(userId, "FAILED");
    }

    @Override
    public List<LoginEvent> getAllEvents() {
        return repo.findAll();
    }
}
