package com.raushan.insighttrack.controller;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.raushan.insighttrack.dto.FeedbackAnalyticsDTO;
import com.raushan.insighttrack.entity.Feedback;

@Controller
public class FeedbackWebSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    public FeedbackWebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendFeedbackToHost(Feedback feedback) {
        String topic = "/topic/feedback/" + feedback.getSessionCode();
        System.out.println("Sending to WebSocket topic: " + topic);
        System.out.println("Message: " + feedback);
        messagingTemplate.convertAndSend(topic, feedback);
    }

    public void sendAnalyticsToHost(FeedbackAnalyticsDTO analytics){
    String topic = "/topic/analytics/" + analytics.getSessionCode();
    System.out.println("Sending analytics to topic: " + topic);
    messagingTemplate.convertAndSend(topic, analytics);
}


}
