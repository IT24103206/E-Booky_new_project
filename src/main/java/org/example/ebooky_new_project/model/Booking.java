package org.example.ebooky_new_project.model;

public class Booking {
    private int id;
    private String title;
    private String author;
    private int price;
    private String rating;
    private String image;
    private String description;

    // Constructors
    public Booking() {}

    public Booking(int id, String title, String author, int price, String rating, String image, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.rating = rating;
        this.image = image;
        this.description = description;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}