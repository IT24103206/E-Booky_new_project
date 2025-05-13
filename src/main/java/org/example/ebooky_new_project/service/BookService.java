package org.example.ebooky_new_project.service;

import org.example.ebooky_new_project.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBook();
    Book getBook(int id);
    Optional<Book> saveBook(Book book);
    Optional<Book> updateBook(Book book);
    boolean deleteBook(int id);
}
