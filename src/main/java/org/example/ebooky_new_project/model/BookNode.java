package org.example.ebooky_new_project.model;

public class BookNode {
    public Book data;
    public BookNode next;

    public BookNode(Book data) {
        this.data = data;
        this.next = null;
    }
}
