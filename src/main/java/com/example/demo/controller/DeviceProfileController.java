package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    @GetMapping
    public List<DeviceProfile> getAllDevices() {
        return service.getAllDevices();
    }

    @GetMapping("/{deviceId}")
    public DeviceProfile getByDeviceId(@PathVariable String deviceId) {
        return service.findByDeviceId(deviceId); // ✅ no Optional, no orElse
    }
}
