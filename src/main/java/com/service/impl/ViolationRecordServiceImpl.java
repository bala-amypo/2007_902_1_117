package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repo;

    public ViolationRecordServiceImpl(ViolationRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public ViolationRecord logViolation(ViolationRecord violation) {
        violation.setDetectedAt(LocalDateTime.now());
        violation.setResolved(false);
        return repo.save(violation);
    }

    @Override
    public List<ViolationRecord> getViolationsByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public ViolationRecord markResolved(Long id) {
        ViolationRecord record = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Violation not found"));

        record.setResolved(true);
        return repo.save(record);
    }

    @Override
    public List<ViolationRecord> getUnresolvedViolations() {
        return repo.findByResolvedFalse();
    }

    @Override
    public List<ViolationRecord> getAllViolations() {
        return repo.findAll();
    }
}
