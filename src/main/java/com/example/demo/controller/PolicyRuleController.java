package com.example.demo;
import org.springframework.http.ResponseEntity;
import java.util.List;

public class PolicyRuleController {
    private final PolicyRuleService ruleService;

    public PolicyRuleController(PolicyRuleService ruleService) {
        this.ruleService = ruleService;
    }

    public ResponseEntity<List<PolicyRule>> all() {
        List<PolicyRule> rules = ruleService.getAllRules();
        return ResponseEntity.ok(rules);
    }
}