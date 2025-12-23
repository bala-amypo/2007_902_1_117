package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceProfileController {

    @Autowired
    private DeviceProfileService service;

    @PostMapping("/register")
    public DeviceProfile registerDevice(@RequestBody DeviceProfile device) {
        return service.registerDevice(device);
    }

    @PutMapping("/trust/{id}")
    public DeviceProfile updateTrustStatus(@PathVariable Long id, @RequestParam boolean status) {
        return service.updateTrustStatus(id, status);
    }

    @GetMapping("/user/{userId}")
    public List<DeviceProfile> getDevicesByUser(@PathVariable Long userId) {
        return service.getDevicesByUser(userId);
    }

    @GetMapping("/{deviceId}")
    public DeviceProfile findByDeviceId(@PathVariable String deviceId) {
        return service.findByDeviceId(deviceId);
    }
}
