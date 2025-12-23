package com.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private Map<Long, UserAccount> db = new HashMap<>();
    private Long counter = 1L;

    @Override
    public UserAccount createUser(UserAccount user) {
        user.setId(counter++);
        user.setStatus("ACTIVE");
        db.put(user.getId(), user);
        return user;
    }

    @Override
    public UserAccount getUserById(Long id) {
        return db.get(id);
    }
}
