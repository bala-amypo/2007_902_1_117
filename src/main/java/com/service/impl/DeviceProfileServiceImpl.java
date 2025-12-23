package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    @Autowired
    private DeviceProfileRepository repository;

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {
        return repository.save(device);
    }

    @Override
    public DeviceProfile updateTrustStatus(Long deviceId, boolean status) {
        DeviceProfile device = repository.findById(deviceId).orElse(null);
        if (device != null) {
            device.setTrusted(status);
            return repository.save(device);
        }
        return null;
    }

    @Override
    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public DeviceProfile findByDeviceId(String deviceId) {
        return repository.findByDeviceId(deviceId);
    }
}
