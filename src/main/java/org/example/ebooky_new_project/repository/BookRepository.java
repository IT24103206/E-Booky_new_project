package org.example.ebooky_new_project.repository;

import org.example.ebooky_new_project.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAllBook();
    Book saveBook(Book book);
    Book updateBook(Book book);
    Boolean deleteBook(int Id);
}
