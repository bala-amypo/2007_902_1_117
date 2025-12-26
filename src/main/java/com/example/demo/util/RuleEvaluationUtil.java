package com.example.demo;
import java.util.List;

public class RuleEvaluationUtil {
    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo, ViolationRecordRepository violationRepo) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
    }

    public void evaluateLoginEvent(LoginEvent event) {
        List<PolicyRule> activeRules = ruleRepo.findByActiveTrue();
        
        for (PolicyRule rule : activeRules) {
            if (rule.getConditionsJson() != null && 
                event.getLoginStatus() != null && 
                event.getLoginStatus().equals(rule.getConditionsJson())) {
                
                ViolationRecord violation = new ViolationRecord();
                violation.setUserId(event.getUserId());
                violation.setEventId(event.getId());
                violation.setSeverity(rule.getSeverity());
                violation.setResolved(false);
                violationRepo.save(violation);
            }
        }
    }
}