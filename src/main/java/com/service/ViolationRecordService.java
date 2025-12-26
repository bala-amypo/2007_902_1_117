package com.example.demo;

import java.util.List;

public interface ViolationRecordService {
    ViolationRecord logViolation(ViolationRecord violation);
    List<ViolationRecord> getUnresolvedViolations();
    ViolationRecord markResolved(Long id);
}