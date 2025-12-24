package com.example.demo.service;

import com.example.demo.entity.PolicyRule;
import java.util.List;

public interface PolicyRuleService {
    PolicyRule createRule(PolicyRule rule);
    PolicyRule updateRule(PolicyRule rule); // ONLY entity, not id + entity
    List<PolicyRule> getActiveRules();
    List<PolicyRule> getAllRules();
}
