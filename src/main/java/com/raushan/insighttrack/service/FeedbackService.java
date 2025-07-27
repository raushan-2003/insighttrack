package com.raushan.insighttrack.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.raushan.insighttrack.controller.FeedbackWebSocketController;
import com.raushan.insighttrack.entity.Feedback;
import com.raushan.insighttrack.repository.FeedbackRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.raushan.insighttrack.dto.FeedbackAnalyticsDTO;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final FeedbackWebSocketController feedbackWebSocketController;

    public FeedbackService(FeedbackRepository feedbackRepository, FeedbackWebSocketController feedbackWebSocketController){
        this.feedbackRepository = feedbackRepository;
        this.feedbackWebSocketController=feedbackWebSocketController;
    }

    public Feedback submitFeedback(String sessionCode, String emotion, String userId) {
        Feedback feedback = new Feedback();
        feedback.setSessionCode(sessionCode);
        feedback.setEmotion(emotion);
        feedback.setUserId(userId);
        feedback.setSubmittedAt(LocalDateTime.now());

        Feedback saved = feedbackRepository.save(feedback);

        feedbackWebSocketController.sendFeedbackToHost(saved);
        sendAnalyticsForSession(sessionCode); // 👈 Separate method

        return saved;
    }

    public void sendAnalyticsForSession(String sessionCode) {
        List<Feedback> feedbackList = feedbackRepository.findBySessionCode(sessionCode);

        Map<String, Integer> emotionCounts = feedbackList.stream()
            .collect(Collectors.groupingBy(Feedback::getEmotion, Collectors.reducing(0, e -> 1, Integer::sum)));

        FeedbackAnalyticsDTO analytics = new FeedbackAnalyticsDTO(sessionCode, emotionCounts);

        feedbackWebSocketController.sendAnalyticsToHost(analytics);
    }

    public List<Feedback> getFeedbackForSession(String sessionCode){
        return feedbackRepository.findBySessionCode(sessionCode);
    }
}
