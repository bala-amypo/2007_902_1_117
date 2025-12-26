package com.example.demo.DeviceProfileController;
import org.springframework.http.ResponseEntity;
import com.example.demo.service.DeviceProfileService;
import com.example.demo.entity.DeviceProfile;

public class DeviceProfileController {
    private final DeviceProfileService deviceService;

    public DeviceProfileController(DeviceProfileService deviceService) {
        this.deviceService = deviceService;
    }

    public ResponseEntity<DeviceProfile> lookup(String deviceId) {
        DeviceProfile device = deviceService.findByDeviceId(deviceId).orElse(null);
        return ResponseEntity.ok(device);
    }
}