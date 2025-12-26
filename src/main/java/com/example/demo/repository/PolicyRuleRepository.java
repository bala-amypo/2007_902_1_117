package com.example.demo;

import java.util.List;

public interface PolicyRuleRepository {
    PolicyRule save(PolicyRule rule);
    List<PolicyRule> findByActiveTrue();
}