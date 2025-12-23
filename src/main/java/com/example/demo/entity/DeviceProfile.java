package com.example.demo.entity;

import java.time.LocalDateTime;

public class DeviceProfile {
    private Long id;
    private String deviceId;
    private Long userId;
    private boolean isTrusted;
    private LocalDateTime lastSeen;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public boolean getIsTrusted() { return isTrusted; }
    public void setIsTrusted(boolean isTrusted) { this.isTrusted = isTrusted; }

    public LocalDateTime getLastSeen() { return lastSeen; }
    public void setLastSeen(LocalDateTime lastSeen) { this.lastSeen = lastSeen; }
}
