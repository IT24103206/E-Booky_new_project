package org.example.ebooky_new_project.model;

import java.util.ArrayList;
import java.util.List;

public class BookLinkedList {
    private BookNode head;

    public void add(Book book) {
        BookNode newNode = new BookNode(book);
        if (head == null) {
            head = newNode;
        } else {
            BookNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean delete(int bookId) {
        if (head == null) return false;

        if (head.data.getBookId() == bookId) {
            head = head.next;
            return true;
        }

        BookNode current = head;
        while (current.next != null) {
            if (current.next.data.getBookId() == bookId) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Book update(Book book) {
        BookNode current = head;
        while (current != null) {
            if (current.data.getBookId() == book.getBookId()) {
                current.data = book;
                return book;
            }
            current = current.next;
        }
        return null;
    }

    public List<Book> toList() {
        List<Book> books = new ArrayList<>();
        BookNode current = head;
        while (current != null) {
            books.add(current.data);
            current = current.next;
        }
        return books;
    }

    public Book getById(int id) {
        BookNode current = head;
        while (current != null) {
            if (current.data.getBookId() == id) return current.data;
            current = current.next;
        }
        return null;
    }

    public Book getByTitle(String title) {
        BookNode current = head;
        while (current != null) {
            if (current.data.getTitle().trim().equalsIgnoreCase(title.trim()))
                return current.data;
            current = current.next;
        }
        return null;
    }
}
