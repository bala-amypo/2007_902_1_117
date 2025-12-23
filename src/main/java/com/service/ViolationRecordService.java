package com.example.demo.service;

import com.example.demo.entity.ViolationRecord;

public interface ViolationRecordService {
    ViolationRecord reportViolation(ViolationRecord violation);
}
