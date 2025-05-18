package org.example.ebooky_new_project.controllers;



import org.example.ebooky_new_project.model.*;
import org.example.ebooky_new_project.service.FeedbackService;
import org.example.ebooky_new_project.service.FeedbackServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FeedbackController {
    private final FeedbackService service;
    public FeedbackController(){
        this.service = new FeedbackServiceImpl();
    }

    @GetMapping("/feedback")
    public List<Feedback> getAllFeedback(){
        return service.getAllFeedback();
    }

    @GetMapping("/feedback/user/{id}")
    public List<Feedback> getUserFeedback(@PathVariable int id){
        User user = new RegularUser();
        user.setUserId(id);

        return service.getAllFeedback(user);
    }

    @GetMapping("/feedback/book/{id}")
    public List<Feedback> getBookFeedback(@PathVariable int id){
        return service.getAllFeedback(id);
    }

    @PostMapping("/feedback")
    public Optional<Feedback> addFeedback(@RequestBody Feedback feedback){
        return service.addFeedback(feedback);
    }
}
