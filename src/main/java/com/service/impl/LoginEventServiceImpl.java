package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginEventRepository;
    private final RuleEvaluationUtil ruleEvaluationUtil;

    public LoginEventServiceImpl(LoginEventRepository loginEventRepository,
                                 RuleEvaluationUtil ruleEvaluationUtil) {
        this.loginEventRepository = loginEventRepository;
        this.ruleEvaluationUtil = ruleEvaluationUtil;
    }

    @Override
    public LoginEvent recordLogin(LoginEvent loginEvent) {
        ruleEvaluationUtil.evaluateLogin(loginEvent);
        return loginEventRepository.save(loginEvent);
    }

    @Override
    public List<LoginEvent> getUserLoginEvents(Long userId) {
        return loginEventRepository.findByUserId(userId);
    }

    @Override
    public List<LoginEvent> getFailedLogins(Long userId) {
        return loginEventRepository.findByUserIdAndLoginStatus(userId, "FAILED");
    }
}
