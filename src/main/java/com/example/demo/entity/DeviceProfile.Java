package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class DeviceProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceId;
    private Long userId;
    private String deviceType;
    private String os;
    private Boolean trusted;

    // getters & setters
}
