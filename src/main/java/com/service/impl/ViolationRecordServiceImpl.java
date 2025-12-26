package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository violationRecordRepository;

    public ViolationRecordServiceImpl(ViolationRecordRepository violationRecordRepository) {
        this.violationRecordRepository = violationRecordRepository;
    }

    @Override
    public ViolationRecord save(ViolationRecord violationRecord) {
        return violationRecordRepository.save(violationRecord);
    }

    @Override
    public List<ViolationRecord> getUserViolations(Long userId) {
        return violationRecordRepository.findByUserId(userId);
    }

    @Override
    public List<ViolationRecord> getUnresolvedViolations() {
        return violationRecordRepository.findByResolvedFalse();
    }
}
