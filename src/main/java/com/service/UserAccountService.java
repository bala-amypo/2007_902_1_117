package com.example.demo.service;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {
    UserAccount createUser(UserAccount user);
    UserAccount getUserById(Long id);
    
    // Add this:
    default UserAccount register(String username, String password) {
        UserAccount user = new UserAccount();
        user.setUsername(username);
        user.setPassword(password);
        return createUser(user);
    }

    // Add login method if needed
    default UserAccount login(String email, String password) {
        // implement logic to find user by email and check password
        return null;
    }
}
