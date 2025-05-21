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
        List<Book> books = bookRepository.getAllBook();
        quickSort(books, 0, books.size() - 1);
        return books;
    }

    private void quickSort(List<Book> books, int low, int high) {
        if (low < high) {
            int pi = partition(books, low, high);
            quickSort(books, low, pi - 1);
            quickSort(books, pi + 1, high);
        }
    }

    private int partition(List<Book> books, int low, int high) {
        Book pivot = books.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (books.get(j).getPrice() < pivot.getPrice()) {
                i++;
                Book temp = books.get(i);
                books.set(i, books.get(j));
                books.set(j, temp);
            }
        }
        Book temp = books.get(i + 1);
        books.set(i + 1, books.get(high));
        books.set(high, temp);
        return i + 1;
    }

    @Override
    public List<Book> sortBook(List<Book> books, String sortBy, boolean ascending) {
        quickSort(books, 0, books.size() - 1, sortBy, ascending);
        return books;
    }

    private void quickSort(List<Book> books, int low, int high, String sortBy, boolean ascending) {
        if (low < high) {
            int pi = partition(books, low, high, sortBy, ascending);
            quickSort(books, low, pi - 1, sortBy, ascending);
            quickSort(books, pi + 1, high, sortBy, ascending);
        }
    }

    private int partition(List<Book> books, int low, int high, String sortBy, boolean ascending) {
        Book pivot = books.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            boolean condition = sortBy.equalsIgnoreCase("price") ?
                    (ascending ? books.get(j).getPrice() < pivot.getPrice() : books.get(j).getPrice() > pivot.getPrice()) :
                    (ascending ? books.get(j).getBookId() < pivot.getBookId() : books.get(j).getBookId() > pivot.getBookId());

            if (condition) {
                i++;
                Book temp = books.get(i);
                books.set(i, books.get(j));
                books.set(j, temp);
            }
        }
        Book temp = books.get(i + 1);
        books.set(i + 1, books.get(high));
        books.set(high, temp);
        return i + 1;
    }

    @Override
    public Book getBook(int id) {
        return bookRepository.getAllBook()
                .stream().filter(b -> b.getBookId() == id).findFirst().orElse(null);
    }

    @Override
    public Book getBook(String title) {
        return bookRepository.getAllBook()
                .stream().filter(b -> b.getTitle().trim().equalsIgnoreCase(title.trim())).findFirst().orElse(null);
    }

    @Override
    public Optional<Book> saveBook(Book book) {
        Book saveBook = bookRepository.saveBook(book);
        return Optional.ofNullable(saveBook);
    }

    @Override
    public Optional<Book> updateBook(Book book) {
        Book updatedBook = bookRepository.updateBook(book);
        return Optional.ofNullable(updatedBook);
    }

    @Override
    public boolean deleteBook(int id) {
        return bookRepository.deleteBook(id);
    }
}
