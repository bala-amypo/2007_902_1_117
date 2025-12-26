package com.example.demo;
import java.util.List;

public class ViolationRecordServiceImpl implements ViolationRecordService {
    private final ViolationRecordRepository violationRepo;

    public ViolationRecordServiceImpl(ViolationRecordRepository violationRepo) {
        this.violationRepo = violationRepo;
    }

    @Override
    public ViolationRecord logViolation(ViolationRecord violation) {
        return violationRepo.save(violation);
    }

    @Override
    public List<ViolationRecord> getUnresolvedViolations() {
        return violationRepo.findByResolvedFalse();
    }

    @Override
    public ViolationRecord markResolved(Long id) {
        ViolationRecord violation = violationRepo.findById(id).orElse(null);
        if (violation != null) {
            violation.setResolved(true);
            return violationRepo.save(violation);
        }
        return null;
    }
}