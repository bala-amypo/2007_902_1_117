package com.example.demo.repository;

import com.example.demo.entity.LoginEvent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface LoginEventRepository {
    LoginEvent save(LoginEvent event);
    List<LoginEvent> findByUserId(Long userId);
    List<LoginEvent> findByUserIdAndLoginStatus(Long userId, String status);
}
