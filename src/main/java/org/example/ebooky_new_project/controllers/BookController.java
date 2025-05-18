package org.example.ebooky_new_project.controllers;

import ch.qos.logback.core.model.Model;
import org.example.ebooky_new_project.model.Book;
import org.example.ebooky_new_project.service.BookService;
import org.example.ebooky_new_project.service.BookServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class BookController {
    private final BookService bookService;

    public BookController() {this.bookService = new BookServiceImpl() {
        @Override
        public List<Book> sortBook(List<Book> books, String sort, boolean ascending) {
            return List.of();
        }
    };}

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable int id) { return bookService.getBook(id);}

    @GetMapping("/book")
    public Book getBook(@RequestParam String title){
        return bookService.getBook(Integer.parseInt(title));
    }

    @GetMapping("/books")
    public List<Book> getAllBook(
            @RequestParam(required = false) String sort,
            @RequestParam(required = false, defaultValue = "true") boolean ascending
    ){
        List<Book> books = bookService.getAllBook();

        if (sort != null) {
            books = bookService.sortBook(books, sort, ascending);
        }

        return books;
    }

    @PostMapping("/book/add")
    public Optional<Book> saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @PatchMapping("/book/update")
    public Optional<Book> updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("/book/delete/{id}")
    public boolean deleteBook(@PathVariable int id){
        return bookService.deleteBook(id);
    }
}

