package com.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private List<LoginEvent> db = new ArrayList<>();

    @Override
    public LoginEvent logEvent(LoginEvent event) {
        event.setTimestamp(LocalDateTime.now());
        db.add(event);
        return event;
    }
}
