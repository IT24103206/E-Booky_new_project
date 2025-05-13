package org.example.ebooky_new_project.service;

import com.oop.ebooky3.model.Book;
import com.oop.ebooky3.model.Feedback;
import com.oop.ebooky3.model.RegularUser;
import com.oop.ebooky3.model.User;
import com.oop.ebooky3.service.FeedbackService;
import com.oop.ebooky3.service.FeedbackServiceImpl;
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
        Book book = new Book();
        book.setBookId(id);

        return service.getAllFeedback(book);
    }

    @PostMapping("/feedback")
    public Optional<Feedback> addFeedback(@RequestBody Feedback feedback){
        return service.addFeedback(feedback);
    }
}

