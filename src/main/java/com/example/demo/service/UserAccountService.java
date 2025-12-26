package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {

    UserAccount save(UserAccount user);          // REQUIRED by AuthController
    UserAccount register(UserAccount user);      // REQUIRED by impl
    UserAccount getUserById(Long id);
    List<UserAccount> getAllUsers();
    UserAccount updateUserStatus(Long id, String status);
}
