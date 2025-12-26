package com.example.demo.service;

import com.example.demo.entity.ViolationRecord;
import java.util.List;

public interface ViolationRecordService {

    List<ViolationRecord> getUnresolvedViolations();

    List<ViolationRecord> getAllViolations();

    ViolationRecord save(ViolationRecord record);
}
