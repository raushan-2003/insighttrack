package com.raushan.insighttrack.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackAnalyticsDTO {
    private String sessionCode;
    private Map<String, Integer> emotionCount;
}
