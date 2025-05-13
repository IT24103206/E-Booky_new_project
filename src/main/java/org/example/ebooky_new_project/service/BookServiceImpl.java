package org.example.ebooky_new_project.service;

import org.example.ebooky_new_project.model.Book;
import org.example.ebooky_new_project.repository.BookRepository;
import org.example.ebooky_new_project.repository.BookRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl() {
        this.bookRepository = new BookRepositoryImpl();
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.getAllBook();
    }


    @Override
    public Book getBook(int id) {
        for (Book b : getAllBook()) {
            if (b.getBookId() == id) {
                return b;
            }
        }
        return null;
    }

    @Override
    public Optional<Book> saveBook(Book book) {
        Book saveBook = bookRepository.saveBook(book);
        if (saveBook != null) {
            return Optional.of(saveBook);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Book> updateBook(Book book) {
        Book updateBook = bookRepository.updateBook(book);
        if (updateBook != null) {
            return Optional.of(book);
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteBook(int id) {
        return bookRepository.deleteBook(id);
    }
}


