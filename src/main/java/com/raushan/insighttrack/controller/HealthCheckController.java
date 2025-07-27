package com.raushan.insighttrack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController{
    
    @GetMapping("/")
    public String home(){
        return "Insight Backend is Running!";
    }
}