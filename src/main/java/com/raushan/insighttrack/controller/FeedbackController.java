package com.raushan.insighttrack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.raushan.insighttrack.entity.Feedback;
import com.raushan.insighttrack.service.FeedbackService;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService){
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<Feedback> submitFeedback(@RequestBody Feedback request ){
        String sessionCode = request.getSessionCode();
        String emotion = request.getEmotion();
        String userId = request.getUserId();

        Feedback feedback = feedbackService.submitFeedback(sessionCode, emotion, userId);
        return ResponseEntity.ok(feedback);
    }

    @GetMapping("/{sessionCode}")
    public ResponseEntity<List<Feedback>> getFeedback(@PathVariable String sessionCode){
        List<Feedback> feedbacksList = feedbackService.getFeedbackForSession(sessionCode);

        return ResponseEntity.ok(feedbacksList);
    }

}
