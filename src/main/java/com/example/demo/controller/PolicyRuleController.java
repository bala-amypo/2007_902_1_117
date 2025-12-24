package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rules")
public class PolicyRuleController {

    @Autowired
    private PolicyRuleService service;

    @PostMapping("/create")
    public PolicyRule createRule(@RequestBody PolicyRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/update")
    public PolicyRule updateRule(@RequestBody PolicyRule rule) {
        return service.updateRule(rule);
    }

    @GetMapping("/active")
    public List<PolicyRule> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping("/all")
    public List<PolicyRule> getAllRules() {
        return service.getAllRules();
    }
}
