package org.example.ebooky_new_project.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ebooky_new_project.model.Feedback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FeedbackRepositoryImpl implements FeedbackRepository{
    private final File file = new File("feedback.txt");
    private final ObjectMapper mapper = new ObjectMapper();
    public FeedbackRepositoryImpl(){
        if(!file.exists()){
            try {
                file.createNewFile();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Feedback> getAllFeedback() {
        List<Feedback> feedbacks = new ArrayList<>();
        try{
            if(file.length()>0){
                feedbacks = mapper.readValue(file,mapper.getTypeFactory().constructType(List.class,Feedback.class));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return feedbacks;
    }

    @Override
    public Feedback addFeedback(Feedback feedback) {
        List<Feedback> feedbacks = getAllFeedback();
        feedbacks.add(feedback);
        try{
            mapper.writeValue(file,feedbacks);
            return feedback;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Feedback updateFeedback(Feedback feedback) {
        return null;
    }

    @Override
    public boolean deleteFeedback(int id) {
        return false;
    }
}

