package com.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private Map<String, PolicyRule> db = new HashMap<>();

    @Override
    public PolicyRule updateRule(PolicyRule updated) {
        db.put(updated.getRuleCode(), updated);
        return updated;
    }
}
