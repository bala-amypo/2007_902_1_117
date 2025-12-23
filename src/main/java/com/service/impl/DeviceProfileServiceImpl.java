package com.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private Map<String, DeviceProfile> db = new HashMap<>();

    @Override
    public DeviceProfile updateDevice(DeviceProfile device) {
        device.setLastSeen(LocalDateTime.now());
        db.put(device.getDeviceId(), device);
        return device;
    }
}
