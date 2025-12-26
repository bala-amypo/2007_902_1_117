package com.example.demo;

import java.util.Optional;

public interface DeviceProfileService {
    DeviceProfile registerDevice(DeviceProfile device);
    Optional<DeviceProfile> findByDeviceId(String deviceId);
    DeviceProfile updateTrustStatus(Long id, Boolean trusted);
}