package org.example.ebooky_new_project.model;

import java.util.Date;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private String isbn;
    private Date publishedDate;
    private String genre;
    private int noPages;
    private double price;
    private String coverPage;

    public Book(){}

    public Book(int bookId,String title,String author,String isbn,Date publishedDate,String genre,int noPages,double price,String coverPage){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.genre = genre;
        this.noPages = noPages;
        this.price = price;
        this.coverPage = coverPage;
    }

    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public Date getPublishedDate() { return publishedDate; }
    public void setPublishedDate(Date publishedDate) { this.publishedDate = publishedDate; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getNoPages() { return noPages; }
    public void setNoPages(int noPages) { this.noPages = noPages; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getCoverPage() { return coverPage; }
    public void setCoverPage(String coverPage) { this.coverPage = coverPage; }


}
