package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RuleEvaluationUtil {

    private final PolicyRuleRepository policyRuleRepository;
    private final ViolationRecordRepository violationRecordRepository;

    public RuleEvaluationUtil(
            PolicyRuleRepository policyRuleRepository,
            ViolationRecordRepository violationRecordRepository
    ) {
        this.policyRuleRepository = policyRuleRepository;
        this.violationRecordRepository = violationRecordRepository;
    }

    public void evaluateLoginEvent(LoginEvent event) {
        List<PolicyRule> rules = policyRuleRepository.findByActiveTrue();

        if (rules == null || rules.isEmpty() || event == null) {
            return;
        }

        for (PolicyRule rule : rules) {
            if (rule.getConditionsJson() != null
                    && event.getLoginStatus() != null
                    && rule.getConditionsJson().contains(event.getLoginStatus())) {

                ViolationRecord violation = new ViolationRecord();
                violation.setSeverity(rule.getSeverity());
                violation.setDetails("Policy violation detected");

                violationRecordRepository.save(violation);
            }
        }
    }
}
