package org.example.ebooky_new_project.service;

import org.example.ebooky_new_project.model.Book;
import org.example.ebooky_new_project.repository.BookRepository;
import org.example.ebooky_new_project.repository.BookRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(){
        this.bookRepository = new BookRepositoryImpl();
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.getAllBook();
    }

    @Override
    public List<Book> sortBook(List<Book> books,String sortBy,boolean ascending) {
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
            boolean condition;
            if (sortBy.equalsIgnoreCase("price")) {
                condition = ascending ?
                        books.get(j).getPrice() < pivot.getPrice() :
                        books.get(j).getPrice() > pivot.getPrice();
            } else {
                // Default fallback to ID if no proper sortBy field
                condition = ascending ?
                        books.get(j).getBookId() < pivot.getBookId() :
                        books.get(j).getBookId() > pivot.getBookId();
            }

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
        for (Book b:getAllBook()){
            if (b.getBookId()==id){
                return b;
            }
        }
        return null;
    }

    @Override
    public Book getBook(String title) {
        for (Book b : getAllBook()) {
            if (b.getTitle().trim().equalsIgnoreCase(title.trim())) {
                return b;
            }
        }
        return null;
    }

    @Override
    public Optional<Book> saveBook(Book book) {
        Book saveBook = bookRepository.saveBook(book);
        if(saveBook != null){
            return Optional.of(saveBook);
        }else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Book> updateBook(Book book) {
        Book updateBook = bookRepository.updateBook(book);
        if(updateBook!= null){
            return Optional.of(book);
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteBook(int id) {
        return bookRepository.deleteBook(id);
    }
}
