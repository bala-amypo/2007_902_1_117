package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;

import java.util.List;
import java.util.Optional;

public interface DeviceProfileService {

    DeviceProfile save(DeviceProfile deviceProfile);

    Optional<DeviceProfile> findByDeviceId(String deviceId);

    List<DeviceProfile> findByUserId(Long userId);
}
