package org.example.ebooky_new_project.controllers;


import org.example.ebooky_new_project.model.Booking;
import org.example.ebooky_new_project.service.BookingService;
import org.example.ebooky_new_project.service.BookingServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {
    private final BookingService service;
    public BookingController(){
        service = new BookingServiceImpl();
    }

    @GetMapping("/booking")
    public List<Booking> getBooking(
            @RequestParam(required = false) Integer userId,
            @RequestParam(required = false) Integer bookId
    ){
        if(userId != null){
            return service.getAllUserBooking(userId);
        }
        if(bookId != null){
            return service.getAllBookBooking(bookId);
        }
        return service.getAllBooking();
    }

    @PostMapping("/booking")
    public Optional<Booking> addBooking(@RequestBody Booking booking){
        return service.addBooking(booking);
    }

    @PutMapping("/booking")
    public Optional<Booking> updateBooking(@RequestBody Booking booking){
        return service.updateBooking(booking);
    }

    @PatchMapping("/booking/change/{id}")
    public boolean changeStatusBooking(@PathVariable int id){
        return service.updateStatusBooking(id);
    }
    @DeleteMapping("/booking/delete/{id}")
    public boolean deleteBooking(@PathVariable int id){
        return service.deleteBooking(id);
    }
}
