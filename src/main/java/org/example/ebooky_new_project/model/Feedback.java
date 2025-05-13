package org.example.ebooky_new_project.model;

public class Feedback {
    private int feedbackId;
    private User feedbackUser;
    private int rating;
    private Book book;
    private String message;

    public Feedback(){}

    public Feedback(int feedbackId,User feedbackUser,int rating,Book book,String message){
        this.feedbackId = feedbackId;
        this.feedbackUser = feedbackUser;
        this.rating = rating;
        this.book = book;
        this.message = message;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public User getFeedbackUser() {
        return feedbackUser;
    }

    public void setFeedbackUser(User feedbackUser) {
        this.feedbackUser = feedbackUser;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

