package com.example.demo.service;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    UserAccount createUser(UserAccount user);

    UserAccount findByUsername(String username);

    UserAccount getUserById(Long id);   // ✅ ADD THIS

    default UserAccount register(String username, String password) {
        UserAccount user = new UserAccount();
        user.setUsername(username);
        user.setPassword(password);
        return createUser(user);
    }

    default UserAccount login(String username, String password) {
        UserAccount user = findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("Invalid username or password");
    }
}
