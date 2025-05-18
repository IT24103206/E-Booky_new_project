package org.example.ebooky_new_project.repository;

import org.example.ebooky_new_project.model.Feedback;

import java.util.List;

public interface FeedbackRepository {
    List<Feedback> getAllFeedback();
    Feedback addFeedback(Feedback feedback);
    Feedback updateFeedback(Feedback feedback);
    boolean deleteFeedback(int id);
}


