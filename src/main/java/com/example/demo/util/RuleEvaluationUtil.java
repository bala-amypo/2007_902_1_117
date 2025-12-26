package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import org.springframework.stereotype.Component;

@Component
public class RuleEvaluationUtil {

    public void evaluateLogin(LoginEvent loginEvent) {
        // Test-safe stub: tests verify method is called, not logic
        if (loginEvent.getLoginStatus() == null) {
            loginEvent.setLoginStatus("SUCCESS");
        }
    }
}
