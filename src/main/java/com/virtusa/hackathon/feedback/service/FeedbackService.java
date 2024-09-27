package com.virtusa.hackathon.feedback.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.hackathon.feedback.entity.Feedback;
import com.virtusa.hackathon.feedback.repository.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;

	public List<Feedback> getAllFeedbacks() {

		List<Feedback> response = feedbackRepository.findAll();

		if (response.isEmpty()) {
			return new ArrayList<Feedback>();
		} else {
			return response;
		}

	}

	public Optional<Feedback> getFeedbackById(int id) {
		return feedbackRepository.findById(id);
	}

	public Feedback createFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}

	public void deleteFeedback(int id) {
		feedbackRepository.deleteById(id);
	}

	public List<Feedback> getFeedbackByUserId(String userId) {
		return feedbackRepository.findByUserId(userId);
	}
}
