package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;
import java.util.Optional;
import java.util.List;

public interface DeviceProfileService {

    DeviceProfile registerDevice(DeviceProfile device);
    Optional<DeviceProfile> findByDeviceId(String deviceId);
    DeviceProfile updateTrustStatus(Long id, boolean trusted);
    List<DeviceProfile> getAllDevices();
}
