package org.example.ebooky_new_project.model;

import java.util.Date;

public class Ebook extends Book{
    private double fileSize;
    private String fileLocation;

    public Ebook(){
        super();
    }

    public Ebook(int bookId, String title, String author, String isbn, Date publishedDate, String genre, String description, int noPages, double price, String coverPage, double fileSize, String fileLocation){
        super(bookId,title,author,isbn,publishedDate,genre,description,noPages,price,coverPage);
        this.fileSize = fileSize;
        this.fileLocation = fileLocation;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize){
        this.fileSize = fileSize;
    }

    public String getFileLocation(){
        return fileLocation;
    }

    public void setFileLocation(String fileLocation){
        this.fileLocation = fileLocation;
    }
}
