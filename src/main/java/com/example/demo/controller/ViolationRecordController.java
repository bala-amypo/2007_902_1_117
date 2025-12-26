package com.example.demo;
import org.springframework.http.ResponseEntity;

public class ViolationRecordController {
    private final ViolationRecordService violationService;

    public ViolationRecordController(ViolationRecordService violationService) {
        this.violationService = violationService;
    }

    public ResponseEntity<ViolationRecord> log(ViolationRecord violation) {
        ViolationRecord logged = violationService.logViolation(violation);
        return ResponseEntity.ok(logged);
    }
}