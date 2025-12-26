package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {

    UserAccount findByUsername(String username);

    List<UserAccount> getAllUsers();

    UserAccount save(UserAccount user);

    void updateUserStatus(Long userId, String status);
}
