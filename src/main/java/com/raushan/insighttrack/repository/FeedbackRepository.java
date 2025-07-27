package com.raushan.insighttrack.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.raushan.insighttrack.entity.Feedback;
import java.util.List;


public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findBySessionCode(String sessionCode);
    
} 