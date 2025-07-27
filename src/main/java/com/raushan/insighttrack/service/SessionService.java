package com.raushan.insighttrack.service;

import com.raushan.insighttrack.entity.Session;
import com.raushan.insighttrack.repository.SessionRepository;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class SessionService {
    private final SessionRepository sessionRepo;

    public SessionService(SessionRepository sessionRepo){
        this.sessionRepo = sessionRepo;
    }


    // Genearte 6 digit session code
    private String generatedSessionCode(){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random rand = new Random();
        String code;
        do{
            code = rand.ints(6,0,chars.length()).mapToObj(i->String.valueOf(chars.charAt(i))).reduce("", String::concat);
        }while(sessionRepo.existsByCode(code));     // ensur uniqueness

        return code;
    }

    public Session createSession(String title, String hostname){
        Session  session = new Session();

        session.setCode(generatedSessionCode());
        session.setTitle(title);
        session.setHostname(hostname);
        session.setCreatedAt(LocalDateTime.now());
        session.setActive(true);

        return sessionRepo.save(session);
    }

    public List<Session> getAllSessions(){
        return sessionRepo.findAll();
    }




}
