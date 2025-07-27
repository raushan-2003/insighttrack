package com.raushan.insighttrack.repository;

import com.raushan.insighttrack.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
    boolean existsByCode(String code);
}
