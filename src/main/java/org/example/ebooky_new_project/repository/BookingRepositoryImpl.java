package org.example.ebooky_new_project.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ebooky_new_project.model.Booking;
import java.io.File;
import java.util.LinkedList;

public class BookingRepositoryImpl implements BookingRepository{

    private final File file = new File("booking.txt");
    private final ObjectMapper mapper;

    public BookingRepositoryImpl(){
        mapper = new ObjectMapper();
        try{
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public LinkedList<Booking> getAllBookings() {
        LinkedList<Booking> bookingLinkedList = new LinkedList<>();

        try{
            bookingLinkedList = mapper.readValue(file, new TypeReference<LinkedList<Booking>>() {});
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return bookingLinkedList;
    }

    @Override
    public Booking addBooking(Booking booking) {
        LinkedList<Booking> bookingLinkedList = getAllBookings();

        if(bookingLinkedList.size()>0){
            booking.setBookingId(bookingLinkedList.get(bookingLinkedList.size()-1).getBookingId()+1);
        }else{
            booking.setBookingId(1);
        }
        bookingLinkedList.add(booking);

        try{
            mapper.writeValue(file,bookingLinkedList);
            return booking;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Booking updateBooking(Booking booking) {
        LinkedList<Booking> bookingLinkedList = getAllBookings();
        boolean isFind = false;
        for (Booking b : bookingLinkedList){
            if(b.getBookingId()== booking.getBookingId()){
                b.setBook(booking.getBook());
                b.setUser(booking.getUser());
                b.setBookingDate(b.getBookingDate());
                b.setReserveDate(b.getReserveDate());
                b.setPicked(b.isPicked());
                isFind = true;
            }
        }
        if(isFind){
            try{
                mapper.writeValue(file,bookingLinkedList);
                return booking;
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean changeStatus(int id) {
        LinkedList<Booking> bookingLinkedList = getAllBookings();
        for(Booking b:bookingLinkedList){
            if(b.getBookingId()==id){
                if(!b.isPicked()){
                    b.setPicked(true);
                    try{
                        mapper.writeValue(file,bookingLinkedList);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean deleteBooking(int id) {
        LinkedList<Booking> bookingLinkedList = getAllBookings();
        boolean isRemove = false;

        for(Booking b : bookingLinkedList){
            if(b.getBookingId()==id){
                bookingLinkedList.remove(b);
                isRemove = true;
            }
        }
        try {
            if(isRemove){
                mapper.writeValue(file,bookingLinkedList);
                return true;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}

