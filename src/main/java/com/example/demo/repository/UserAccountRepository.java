package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface UserAccountRepository {
    UserAccount save(UserAccount user);
    Optional<UserAccount> findById(Long id);
    List<UserAccount> findAll();
}