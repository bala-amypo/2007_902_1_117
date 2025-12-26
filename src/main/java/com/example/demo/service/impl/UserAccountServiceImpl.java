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
    public UserAccount save(UserAccount user) {
        return repository.save(user);
    }

    @Override
    public UserAccount getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public UserAccount getByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount user = repository.findById(id).orElseThrow();
        user.setStatus(status);
        return repository.save(user);
    }
}
