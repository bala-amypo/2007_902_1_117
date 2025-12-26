package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;
import java.util.List;

public interface DeviceProfileService {

    List<DeviceProfile> getAllDevices();

    DeviceProfile findByDeviceId(String deviceId);
}
