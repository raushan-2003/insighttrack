package com.raushan.insighttrack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raushan.insighttrack.entity.Session;
import com.raushan.insighttrack.service.SessionService;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }

@PostMapping
public ResponseEntity<Session> createSession(@RequestBody Session request) {
    String title = request.getTitle();
    String hostName = request.getHostname();
    Session session = sessionService.createSession(title, hostName); 
    return ResponseEntity.ok(session);
}

@GetMapping("/all")
public ResponseEntity<List<Session>> getAllSessions(){
    return ResponseEntity.ok(sessionService.getAllSessions());
}




}
