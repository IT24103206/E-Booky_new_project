package org.example.ebooky_new_project.service;


import org.example.ebooky_new_project.model.Booking;
import org.example.ebooky_new_project.repository.BookingRepository;
import org.example.ebooky_new_project.repository.BookingRepositoryImpl;

import java.util.LinkedList;
import java.util.Optional;

public class BookingServiceImpl implements BookingService{

    private final BookingRepository repository;
    public BookingServiceImpl(){
        this.repository = new BookingRepositoryImpl();
    }

    @Override
    public LinkedList<Booking> getAllBooking() {
        return repository.getAllBookings();
    }

    @Override
    public LinkedList<Booking> getAllUserBooking(int userId) {
        LinkedList<Booking> resultList = new LinkedList<>();
        for(Booking b:repository.getAllBookings()){
            if(b.getUser().getUserId()==userId){
                resultList.add(b);
            }
        }
        return resultList;
    }

    @Override
    public LinkedList<Booking> getAllBookBooking(int bookId) {
        LinkedList<Booking> resultList = new LinkedList<>();
        for(Booking b:repository.getAllBookings()){
            if(b.getBook().getBookId() == bookId){
                resultList.add(b);
            }
        }
        return resultList;
    }

    @Override
    public Optional<Booking> addBooking(Booking booking) {
        Booking currentBooking = repository.addBooking(booking);
        if(currentBooking!= null){
            return Optional.of(currentBooking);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Booking> updateBooking(Booking booking) {
        Booking currentBooking = repository.updateBooking(booking);
        if(currentBooking!= null){
            return Optional.of(currentBooking);
        }
        return Optional.empty();
    }

    @Override
    public boolean updateStatusBooking(int id) {
        return repository.changeStatus(id);
    }

    @Override
    public boolean deleteBooking(int id) {
        return repository.deleteBooking(id);
    }
}

