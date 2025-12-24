package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    @Autowired
    private PolicyRuleRepository repository;

    @Override
    public PolicyRule createRule(PolicyRule rule) {
        return repository.save(rule);
    }

    @Override
    public PolicyRule updateRule(PolicyRule rule) {
        return repository.save(rule);
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return repository.findAll();
    }
}
