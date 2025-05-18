package org.example.ebooky_new_project.service;

import org.example.ebooky_new_project.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBook();
    List<Book> sortBook(List<Book> books,String sortBy,boolean ascending);
    Book getBook(int id);
    Book getBook(String title);
    Optional<Book> saveBook(Book book);
    Optional<Book> updateBook(Book book);
    boolean deleteBook(int id);
}
