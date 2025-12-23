package com.example.demo.service;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    UserAccount createUser(UserAccount user);

    UserAccount getUserById(Long id);

    // Updated register method to match AuthController
    default UserAccount register(String username, String email, String password) {
        UserAccount user = new UserAccount();
        user.setUsername(username);
        user.setEmail(email);  // set email as well
        user.setPassword(password);
        return createUser(user);
    }

    // Add login method
    default UserAccount login(String email, String password) {
        // implement logic to find user by email and check password
        return null;
    }
}
