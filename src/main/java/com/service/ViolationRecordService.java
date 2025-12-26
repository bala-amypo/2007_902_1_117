package com.example.demo.service;

import com.example.demo.entity.ViolationRecord;

import java.util.List;

public interface ViolationRecordService {

    ViolationRecord save(ViolationRecord violationRecord);

    List<ViolationRecord> getUserViolations(Long userId);

    List<ViolationRecord> getUnresolvedViolations();
}
