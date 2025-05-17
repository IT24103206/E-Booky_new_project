package org.example.ebooky_new_project.repository;


import org.example.ebooky_new_project.model.Booking;

import java.util.LinkedList;

public interface BookingRepository {
    LinkedList<Booking> getAllBookings();
    Booking addBooking(Booking booking);
    Booking updateBooking(Booking booking);
    boolean changeStatus(int id);
    boolean deleteBooking(int id);
}

