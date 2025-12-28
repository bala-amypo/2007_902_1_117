// package com.example.demo.repository;

// import com.example.demo.entity.PolicyRule;
// import java.util.*;

// public interface PolicyRuleRepository {
//     PolicyRule save(PolicyRule rule);
//     List<PolicyRule> findAll();
//     List<PolicyRule> findByActiveTrue();
//     Optional<PolicyRule> findById(Long id);
// }

package com.example.demo.repository;

import com.example.demo.entity.PolicyRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRuleRepository extends JpaRepository<PolicyRule, Long> {

    List<PolicyRule> findByActiveTrue();
}
