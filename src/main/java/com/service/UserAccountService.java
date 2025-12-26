package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;
import java.util.Optional;

public interface UserAccountService {

    UserAccount registerUser(UserAccount userAccount);

    Optional<UserAccount> findByUsername(String username);

    Optional<UserAccount> findByEmail(String email);

    List<UserAccount> getAllUsers();
}
