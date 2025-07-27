package com.raushan.insighttrack.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime; 

@Entity
@Data
public class UserSession {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String sessionCode;
    private String userId;
    private LocalDateTime joinedAt;
}
