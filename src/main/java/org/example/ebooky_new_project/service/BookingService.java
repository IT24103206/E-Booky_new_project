package org.example.ebooky_new_project.service;



import org.example.ebooky_new_project.model.Booking;
import java.util.LinkedList;
import java.util.Optional;

public interface BookingService {
    LinkedList<Booking> getAllBooking();
    LinkedList<Booking> getAllUserBooking(int userid);
    LinkedList<Booking> getAllBookBooking(int bookid);
    Optional<Booking> addBooking(Booking booking);
    Optional<Booking> updateBooking(Booking booking);
    boolean updateStatusBooking(int id);
    boolean deleteBooking(int id);
}

