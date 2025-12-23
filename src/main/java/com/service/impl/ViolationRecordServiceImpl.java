package com.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private List<ViolationRecord> db = new ArrayList<>();

    @Override
    public ViolationRecord reportViolation(ViolationRecord violation) {
        violation.setDetectedAt(LocalDateTime.now());
        violation.setResolved(false);
        db.add(violation);
        return violation;
    }
}
