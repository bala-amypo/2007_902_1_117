package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface ViolationRecordRepository {
    ViolationRecord save(ViolationRecord violation);
    List<ViolationRecord> findByResolvedFalse();
    Optional<ViolationRecord> findById(Long id);
}