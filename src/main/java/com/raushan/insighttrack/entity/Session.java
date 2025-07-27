package com.raushan.insighttrack.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String code;         // Unique code for each session
    private String title;        // Title for the session
    private String hostname;     // Who created the session
    private LocalDateTime createdAt;
    private boolean active;
}
