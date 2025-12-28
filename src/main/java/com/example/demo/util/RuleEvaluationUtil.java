package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.stereotype.Component;

@Component
// public class RuleEvaluationUtil {

//     private final PolicyRuleRepository policyRuleRepository;
//     private final ViolationRecordRepository violationRecordRepository;

//     public RuleEvaluationUtil(
//             PolicyRuleRepository policyRuleRepository,
//             ViolationRecordRepository violationRecordRepository
//     ) {
//         this.policyRuleRepository = policyRuleRepository;
//         this.violationRecordRepository = violationRecordRepository;
//     }

//     public void evaluateLoginEvent(LoginEvent event) {
//         // no-op for now (required for compilation)
//     }
// }


public void evaluateLoginEvent(LoginEvent event) {
    List<PolicyRule> rules = ruleRepo.findByActiveTrue();

    for (PolicyRule rule : rules) {
        if (rule.getConditionsJson() != null &&
            rule.getConditionsJson().contains(event.getLoginStatus())) {

            ViolationRecord v = new ViolationRecord();
            v.setSeverity(rule.getSeverity());
            v.setDetails("Rule violation triggered");

            violationRepo.save(v);
        }
    }
}
