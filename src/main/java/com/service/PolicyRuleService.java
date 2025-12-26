package com.example.demo;

import java.util.List;

public interface PolicyRuleService {
    PolicyRule createRule(PolicyRule rule);
    List<PolicyRule> getActiveRules();
    List<PolicyRule> getAllRules();
}