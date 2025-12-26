package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;
import java.util.List;

public interface DeviceProfileService {

    DeviceProfile findByDeviceId(String deviceId);

    List<DeviceProfile> getDevicesByUser(Long userId);

    DeviceProfile save(DeviceProfile device);
}
