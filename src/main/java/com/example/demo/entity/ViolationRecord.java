// package com.example.demo.entity;

// public class ViolationRecord {

//     private Long id;
//     private Long userId;
//     private Long eventId;
//     private String severity;
//     private String details;
//     private Boolean resolved;

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Long getUserId() { return userId; }
//     public void setUserId(Long userId) { this.userId = userId; }

//     public Long getEventId() { return eventId; }
//     public void setEventId(Long eventId) { this.eventId = eventId; }

//     public String getSeverity() { return severity; }
//     public void setSeverity(String severity) { this.severity = severity; }

//     public String getDetails() { return details; }
//     public void setDetails(String details) { this.details = details; }

//     public Boolean getResolved() { return resolved; }
//     public void setResolved(Boolean resolved) { this.resolved = resolved; }
// }


package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "violation_record")
public class ViolationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String ruleName;

    private String severity;

    private String description;

    private LocalDateTime createdAt;

    public ViolationRecord() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity
