package com.example.demo.repository;

import com.example.demo.entity.UserAccount;
import java.util.*;

// public interface UserAccountRepository {
//     UserAccount save(UserAccount user);
//     Optional<UserAccount> findById(Long id);
//     List<UserAccount> findAll();
// }

@Repository
public interface UserAccountRepository
        extends JpaRepository<UserAccount, Long> {
            UserAccount save(UserAccount user);
    Optional<UserAccount> findById(Long id);
    List<UserAccount> findAll();
}
