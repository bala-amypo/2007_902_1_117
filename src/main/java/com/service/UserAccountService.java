// UserAccountService.java
package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {
    UserAccount register(String username, String password);
    boolean validateLogin(String username, String password);
    void updateUserStatus(Long userId, String status);
    List<UserAccount> getAllUsers();
}
