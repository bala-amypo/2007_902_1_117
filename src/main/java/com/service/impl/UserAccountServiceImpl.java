package com.example.demo;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;

public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserAccountServiceImpl(UserAccountRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        if (user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepo.save(user);
    }

    @Override
    public UserAccount getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount user = userRepo.findById(id).orElse(null);
        if (user != null) {
            user.setStatus(status);
            return userRepo.save(user);
        }
        return null;
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userRepo.findAll();
    }
}