package com.example.demo.entity;


import jakarta.persistence.*;


@Entity
public class PolicyRule {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String ruleCode;
private String description;
private String severity;
private String conditionsJson;
private Boolean active;


public PolicyRule() {}
// getters and setters
}