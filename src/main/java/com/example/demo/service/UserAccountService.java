package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {

    UserAccount save(UserAccount user);

    UserAccount getUserById(Long id);

    UserAccount getByUsername(String username);

    List<UserAccount> getAllUsers();

    UserAccount updateUserStatus(Long id, String status);
}
