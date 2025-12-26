package com.example.demo;

import java.time.LocalDateTime;

public class DeviceProfile {
    private Long id;
    private String deviceId;
    private String deviceType;
    private String osVersion;
    private Long userId;
    private Boolean isTrusted;
    private LocalDateTime lastSeen;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }
    
    public String getDeviceType() { return deviceType; }
    public void setDeviceType(String deviceType) { this.deviceType = deviceType; }
    
    public String getOsVersion() { return osVersion; }
    public void setOsVersion(String osVersion) { this.osVersion = osVersion; }
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    
    public Boolean getIsTrusted() { return isTrusted; }
    public void setIsTrusted(Boolean isTrusted) { this.isTrusted = isTrusted; }
    
    public LocalDateTime getLastSeen() { return lastSeen; }
    public void setLastSeen(LocalDateTime lastSeen) { this.lastSeen = lastSeen; }
}