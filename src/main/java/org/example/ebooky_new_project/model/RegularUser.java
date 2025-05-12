package org.example.ebooky_new_project.model;

public class RegularUser extends User{
//    private LinkedList<Book> purchasedBook;

    public RegularUser(){
        super();
    }
    public RegularUser(int userId,String firstName,String lastName,String email,String password){
        super(userId,firstName,lastName,email,password);
//        this.purchasedBook = books;
    }

//    public LinkedList<Book> getPurchasedBook() {
//        return purchasedBook;
//    }
//
//    public void setPurchasedBook(LinkedList<Book> purchasedBook) {
//        this.purchasedBook = purchasedBook;
//    }
}
