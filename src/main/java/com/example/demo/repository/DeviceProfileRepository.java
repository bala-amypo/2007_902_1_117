package com.example.demo;

import java.util.Optional;

public interface DeviceProfileRepository {
    DeviceProfile save(DeviceProfile device);
    Optional<DeviceProfile> findById(Long id);
    Optional<DeviceProfile> findByDeviceId(String deviceId);
}