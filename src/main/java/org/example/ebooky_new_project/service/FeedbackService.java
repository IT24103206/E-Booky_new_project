package org.example.ebooky_new_project.service;

import org.example.ebooky_new_project.model.Book;
import org.example.ebooky_new_project.model.Feedback;
import org.example.ebooky_new_project.model.User;

import java.util.List;
import java.util.Optional;

public interface FeedbackService {
    List<Feedback> getAllFeedback();
    List<Feedback> getAllFeedback(int id);
    List<Feedback> getAllFeedback(User user);
    Optional<Feedback> addFeedback(Feedback feedback);
    Optional<Feedback> updateFeedback(Feedback feedback);
    boolean deleteFeedback(int id);
}
