package com.virtusa.hackathon.feedback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.hackathon.feedback.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

	 List<Feedback> findByUserId(String userId);
}