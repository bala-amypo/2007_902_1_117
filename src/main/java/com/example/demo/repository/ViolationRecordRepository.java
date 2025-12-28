package com.example.demo.repository;

import com.example.demo.entity.ViolationRecord;
import java.util.*;
@Repository
public interface ViolationRecordRepository {
    ViolationRecord save(ViolationRecord violation);
    Optional<ViolationRecord> findById(Long id);
    List<ViolationRecord> findByResolvedFalse();
}

