package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import org.springframework.stereotype.Service;
import com.example.demo.util.RuleEvaluationUtil;
import java.util.List;
@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository repo;
    private final RuleEvaluationUtil evaluator;
     private final LoginEventRepository loginEventRepository;

    public LoginEventServiceImpl(LoginEventRepository repo, RuleEvaluationUtil evaluator, LoginEventRepository loginEventRepository) {
        this.repo = repo;
        this.evaluator = evaluator;
        this.loginEventRepository = loginEventRepository;
    }

    @Override
    public LoginEvent recordLogin(LoginEvent event) {
        LoginEvent saved = repo.save(event);
        evaluator.evaluateLoginEvent(saved);
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
    public List<LoginEvent> getUserLoginEvents(Long userId) {
        return loginEventRepository.findByUserId(userId);
    }
}