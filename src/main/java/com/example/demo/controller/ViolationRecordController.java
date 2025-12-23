package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/violations")
public class ViolationRecordController {

    @Autowired
    private ViolationRecordService service;

    @PostMapping("/log")
    public ViolationRecord logViolation(@RequestBody ViolationRecord record) {
        return service.logViolation(record);
    }

    @GetMapping("/user/{userId}")
    public List<ViolationRecord> getViolationsByUser(@PathVariable Long userId) {
        return service.getViolationsByUser(userId);
    }

    @PutMapping("/resolve/{id}")
    public ViolationRecord markResolved(@PathVariable Long id) {
        return service.markResolved(id);
    }

    @GetMapping("/unresolved")
    public List<ViolationRecord> getUnresolvedViolations() {
        return service.getUnresolvedViolations();
    }

    @GetMapping("/all")
    public List<ViolationRecord> getAllViolations() {
        return service.getAllViolations();
    }
}
