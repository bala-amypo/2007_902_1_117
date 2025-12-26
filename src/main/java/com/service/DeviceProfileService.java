package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;
import java.util.List;

public interface DeviceProfileService {

    DeviceProfile registerDevice(DeviceProfile device);

    DeviceProfile findByDeviceId(String deviceId);

    DeviceProfile updateTrustStatus(Long deviceId, boolean trusted);

    List<DeviceProfile> getDevicesByUser(Long userId);
}
