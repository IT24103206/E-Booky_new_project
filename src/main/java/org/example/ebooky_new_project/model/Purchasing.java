package org.example.ebooky_new_project.model;


import java.util.Date;

public class Purchasing {
    private int purchaseId;
    private User purchaseUser;
    private Book purchaseBook;
    private int quantity;
    private Date purchaseDate;

    public Purchasing(){}
    public Purchasing(int  purchaseId,User purchaseUser,Book purchaseBook,int quantity,Date purchaseDate){
        this.purchaseId = purchaseId;
        this.purchaseUser = purchaseUser;
        this.purchaseBook = purchaseBook;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
    }


    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public User getPurchaseUser() {
        return purchaseUser;
    }

    public void setPurchaseUser(User purchaseUser) {
        this.purchaseUser = purchaseUser;
    }

    public Book getPurchaseBook() {
        return purchaseBook;
    }

    public void setPurchaseBook(Book purchaseBook) {
        this.purchaseBook = purchaseBook;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}


