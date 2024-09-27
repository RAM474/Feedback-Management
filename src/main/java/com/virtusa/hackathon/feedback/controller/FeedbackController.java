package com.virtusa.hackathon.feedback.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.hackathon.feedback.entity.Feedback;
import com.virtusa.hackathon.feedback.service.FeedbackService;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	@GetMapping
	public List<Feedback> getAllFeedback() {
		return feedbackService.getAllFeedbacks();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable int id) {
		Optional<Feedback> feedback = feedbackService.getFeedbackById(id);
		return feedback.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public Feedback createFeedback(@RequestBody Feedback feedback) {
		return feedbackService.createFeedback(feedback);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFeedback(@PathVariable int id) {
		feedbackService.deleteFeedback(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/user/{userId}")
	public List<Feedback> getFeedbackByuserId(@PathVariable String userId) {
		return feedbackService.getFeedbackByUserId(userId);
	}
}