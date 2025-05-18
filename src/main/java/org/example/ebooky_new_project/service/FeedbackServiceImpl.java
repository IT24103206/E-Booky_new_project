package org.example.ebooky_new_project.service;

import org.example.ebooky_new_project.model.Feedback;
import org.example.ebooky_new_project.model.User;
import org.example.ebooky_new_project.repository.FeedbackRepository;
import org.example.ebooky_new_project.repository.FeedbackRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository repository;
    private final List<Feedback> feedbackList;
    public FeedbackServiceImpl(){
        this.repository = new FeedbackRepositoryImpl();
        this.feedbackList = repository.getAllFeedback();
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return repository.getAllFeedback();

    }

    @Override
    public List<Feedback> getAllFeedback(int id) {
        List<Feedback> bookFeedbacks = new ArrayList<>();

        for(Feedback f: repository.getAllFeedback()){
            if(f.getBook().getBookId()==id){
                bookFeedbacks.add(f);
            }
        }
        return bookFeedbacks;
    }

    @Override
    public List<Feedback> getAllFeedback(User user) {
        List<Feedback> userFeedback = new ArrayList<>();

        for(Feedback f: feedbackList){
            if(f.getFeedbackUser().getUserId()==user.getUserId()){
                userFeedback.add(f);
            }
        }
        return userFeedback;

    }

    @Override
    public Optional<Feedback> addFeedback(Feedback feedback) {
        Feedback createFeedback = repository.addFeedback(feedback);
        if(createFeedback != null){
            return Optional.of(createFeedback);
        }
        return Optional.empty();

    }

    @Override
    public Optional<Feedback> updateFeedback(Feedback feedback) {
        return null;
    }

    @Override
    public boolean deleteFeedback(int id) {
        return false;
    }
}