package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class DeviceProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceId;
    private String deviceType;
    private String os;

    // getters & setters
}
