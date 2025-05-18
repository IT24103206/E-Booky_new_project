package org.example.ebooky_new_project.model;

import java.util.Date;

public class PrintedBook extends Book{
    private int availableStock;

    public PrintedBook(){
        super();
    }

    public PrintedBook(int bookId, String title, String author, String isbn, Date publishedDate, String genre, String description, int noPages, double price, String coverPage, int availableStock){
        super(bookId, title, author, isbn, publishedDate, genre,description, noPages, price, coverPage);
        this.availableStock = availableStock;
    }

    public int getAvailableStock(){
        return availableStock;
    }

    public void setAvailableStock(int availableStock){
        this.availableStock = availableStock;
    }
}
