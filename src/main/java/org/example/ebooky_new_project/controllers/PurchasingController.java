package org.example.ebooky_new_project.controllers;

import org.example.ebooky_new_project.model.Purchasing;
import org.example.ebooky_new_project.model.RegularUser;
import org.example.ebooky_new_project.model.User;
import org.example.ebooky_new_project.service.PurchasingService;
import org.example.ebooky_new_project.service.PurchasingServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
public class PurchasingController {
    private final PurchasingService service;
    public PurchasingController(){
        this.service = new PurchasingServiceImpl();
    }

    @GetMapping("/purchasing")
    public List<Purchasing> getAllFeedback(){
        return service.getAllPurchasing();
    }

    @GetMapping("/purchasing/book/{id}")
    public List<Purchasing> getBookFeedback(@PathVariable int id) {
        Book book = new Book();
        book.setBookId(id);
        return service.getAllPurchasing(book);
    }

    @GetMapping("/purchasing/user/{id}")
    public List<Purchasing> getUserFeedback(@PathVariable int id) {
        User user = new RegularUser();
        user.setUserId(id);
        return service.getAllPurchasing(user);
    }

    @PostMapping("/purchasing/add")
    public Optional<Purchasing> addPurchaser(@RequestBody Purchasing purchasing){
        return service.addPurchasing(purchasing);
    }

    @PutMapping("/purchasing")
    public Optional<Purchasing> updatePurchasing(@RequestBody Purchasing purchasing){
        return service.updatePurchasing(purchasing);
    }

    @DeleteMapping("/purchasing/{id}")
    public boolean deleteMapping(@PathVariable int id){
        return false;
    }


}
