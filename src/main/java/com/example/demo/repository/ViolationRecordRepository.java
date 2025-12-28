// package com.example.demo.repository;

// import com.example.demo.entity.ViolationRecord;
// import java.util.*;

// public interface ViolationRecordRepository {
//     ViolationRecord save(ViolationRecord violation);
//     Optional<ViolationRecord> findById(Long id);
//     List<ViolationRecord> findByResolvedFalse();
// }

package com.example.demo.repository;

import com.example.demo.entity.ViolationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViolationRecordRepository
        extends JpaRepository<ViolationRecord, Long> {
}
