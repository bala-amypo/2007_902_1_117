package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository deviceProfileRepository;

    public DeviceProfileServiceImpl(DeviceProfileRepository deviceProfileRepository) {
        this.deviceProfileRepository = deviceProfileRepository;
    }

    @Override
    public DeviceProfile save(DeviceProfile deviceProfile) {
        return deviceProfileRepository.save(deviceProfile);
    }

    @Override
    public Optional<DeviceProfile> findByDeviceId(String deviceId) {
        return deviceProfileRepository.findByDeviceId(deviceId);
    }

    @Override
    public List<DeviceProfile> findByUserId(Long userId) {
        return deviceProfileRepository.findByUserId(userId);
    }
}
