package com.example.demo;
import java.util.Optional;

public class DeviceProfileServiceImpl implements DeviceProfileService {
    private final DeviceProfileRepository deviceRepo;

    public DeviceProfileServiceImpl(DeviceProfileRepository deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {
        return deviceRepo.save(device);
    }

    @Override
    public Optional<DeviceProfile> findByDeviceId(String deviceId) {
        return deviceRepo.findByDeviceId(deviceId);
    }

    @Override
    public DeviceProfile updateTrustStatus(Long id, Boolean trusted) {
        DeviceProfile device = deviceRepo.findById(id).orElse(null);
        if (device != null) {
            device.setIsTrusted(trusted);
            return deviceRepo.save(device);
        }
        return null;
    }
}