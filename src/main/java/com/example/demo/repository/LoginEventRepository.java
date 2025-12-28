// package com.example.demo.repository;

// import com.example.demo.entity.LoginEvent;
// import org.springframework.stereotype.Repository;

// import java.util.List;
// import java.util.Optional;

// @Repository
// public interface LoginEventRepository {
//     LoginEvent save(LoginEvent event);
//     List<LoginEvent> findByUserId(Long userId);
//     List<LoginEvent> findByUserIdAndLoginStatus(Long userId, String status);
// }


package com.example.demo.repository;

import com.example.demo.entity.LoginEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginEventRepository extends JpaRepository<LoginEvent, Long> {

    List<LoginEvent> findByUserId(Long userId);

    List<LoginEvent> findByUserIdAndLoginStatus(Long userId, String loginStatus);
}
