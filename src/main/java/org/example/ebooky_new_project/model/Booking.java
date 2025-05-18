package org.example.ebooky_new_project.model;

import java.util.Date;
public class Booking {
    private int bookingId;
    private PrintedBook book;
    private RegularUser user;
    private Date bookingDate;
    private Date reserveDate;
    private boolean isPicked;

    public Booking(){}


    public Booking(PrintedBook book,RegularUser user,Date bookingDate,Date reserveDate,boolean isPicked){
        this.book = book;
        this.user = user;
        this.bookingDate = bookingDate;
        this.reserveDate= reserveDate;
        this.isPicked = isPicked;
    }
    public Booking(int bookingId,PrintedBook book,RegularUser user,Date bookingDate,Date reserveDate){
        this.bookingId = bookingId;
        this.book = book;
        this.user = user;
        this.bookingDate = bookingDate;
        this.reserveDate= reserveDate;
    }


    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public PrintedBook getBook() {
        return book;
    }

    public void setBook(PrintedBook book) {
        this.book = book;
    }

    public RegularUser getUser() {
        return user;
    }

    public void setUser(RegularUser user) {
        this.user = user;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public boolean isPicked() {
        return isPicked;
    }

    public void setPicked(boolean picked) {
        isPicked = picked;
    }
}

