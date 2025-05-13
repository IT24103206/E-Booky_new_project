package org.example.ebooky_new_project.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.example.ebooky_new_project.model.Booking;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final String BOOKS_FILE = "src/main/resources/data/books.json";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<Booking> books = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Initialize with default books if file doesn't exist
        File file = new File(BOOKS_FILE);
        if (!file.exists()) {
            books.add(new Booking(1, "The Power of Now", "Eckhart Tolle", 2500, "★★★★☆",
                    "https://projectlifemastery.com/wp-content/uploads/2012/06/Eckhart-Tolle-The-Power-Of-Now-Review.jpg",
                    "The Power of Now is a guide to spiritual enlightenment..."));
            books.add(new Booking(2, "To Kill a Mockingbird", "Harper Lee", 1800, "★★★☆☆",
                    "https://www.harryhartog.com.au/cdn/shop/files/9780099466734.jpg?v=1725013209&width=480",
                    "To Kill a Mockingbird is a novel by Harper Lee..."));
            books.add(new Booking(3, "Harry Potter and the Half-Blood Prince", "J.K. Rowling", 3200, "★★★★★",
                    "https://media.harrypotterfanzone.com/half-blood-prince-us-childrens-edition-2013-600x0-c-default.jpg",
                    "Harry Potter and the Half-Blood Prince is the sixth novel..."));
            books.add(new Booking(4, "The Alchemist", "Paulo Coelho", 2100, "★★★★☆",
                    "https://images-na.ssl-images-amazon.com/images/I/71aFt4+OTOL.jpg",
                    "The Alchemist follows a young Andalusian shepherd..."));
            books.add(new Booking(6, "Ikigai", "Héctor García and Francesc Miralles", 2300, "★★★★☆",
                    "https://images-na.ssl-images-amazon.com/images/I/71tbalAHYCL.jpg",
                    "The people of Japan believe that everyone has an ikigai..."));
            saveBooks();
        } else {
            loadBooks();
        }
    }

    public List<Booking> getAllBooks() {
        return books;
    }

    public Optional<Booking> getBookById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst();
    }

    public Booking addBook(Booking book) {
        book.setId(generateId());
        books.add(book);
        saveBooks();
        return book;
    }

    public Optional<Booking> updateBook(int id, Booking updatedBook) {
        Optional<Booking> existingBook = getBookById(id);
        if (existingBook.isPresent()) {
            Booking book = existingBook.get();
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setPrice(updatedBook.getPrice());
            book.setRating(updatedBook.getRating());
            book.setImage(updatedBook.getImage());
            book.setDescription(updatedBook.getDescription());
            saveBooks();
        }
        return existingBook;
    }

    public boolean deleteBook(int id) {
        boolean removed = books.removeIf(book -> book.getId() == id);
        if (removed) {
            saveBooks();
        }
        return removed;
    }

    private void loadBooks() {
        try {
            books = objectMapper.readValue(new File(BOOKS_FILE), new TypeReference<List<Booking>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveBooks() {
        try {
            objectMapper.writeValue(new File(BOOKS_FILE), books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int generateId() {
        return books.stream().mapToInt(Booking::getId).max().orElse(0) + 1;
    }

    public List<Booking> searchBooks(String title, String author) {
        return searchBooks(title,author);
    }
}


