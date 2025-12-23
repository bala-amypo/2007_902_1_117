package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    @Autowired
    private ViolationRecordRepository repository;

    @Override
    public ViolationRecord logViolation(ViolationRecord record) {
        return repository.save(record);
    }

    @Override
    public List<ViolationRecord> getViolationsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public ViolationRecord markResolved(Long id) {
        ViolationRecord record = repository.findById(id).orElse(null);
        if (record != null) {
            record.setResolved(true);
            return repository.save(record);
        }
        return null;
    }

    @Override
    public List<ViolationRecord> getUnresolvedViolations() {
        return repository.findByResolvedFalse();
    }

    @Override
    public List<ViolationRecord> getAllViolations() {
        return repository.findAll();
    }
}
