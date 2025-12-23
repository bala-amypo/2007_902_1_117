package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccount register(String username, String password) {
        UserAccount user = new UserAccount();
        user.setUsername(username);
        user.setPassword(password);
        return repository.save(user);
    }

    @Override
    public boolean validateLogin(String username, String password) {
        return repository.findByUsername(username)
                         .map(user -> user.getPassword().equals(password))
                         .orElse(false);
    }

    @Override
    public void updateUserStatus(Long userId, String status) {
        UserAccount user = repository.findById(userId).orElseThrow();
        user.setStatus(status);
        repository.save(user);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repository.findAll();
    }
}
