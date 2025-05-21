package org.example.ebooky_new_project.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ebooky_new_project.model.Book;
import org.example.ebooky_new_project.model.BookLinkedList;

import java.io.*;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private final File file = new File("book.txt");
    private final ObjectMapper objectMapper;

    public BookRepositoryImpl() {
        this.objectMapper = new ObjectMapper();
        objectMapper.activateDefaultTyping(
                objectMapper.getPolymorphicTypeValidator(),
                ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT,
                JsonTypeInfo.As.PROPERTY
        );
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Book> getAllBook() {
        BookLinkedList bookLinkedList = new BookLinkedList();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Book book = objectMapper.readValue(line, Book.class);
                bookLinkedList.add(book);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bookLinkedList.toList();
    }

    @Override
    public Book saveBook(Book book) {
        List<Book> books = getAllBook();
        int id = 1;
        if (!books.isEmpty()) {
            id = books.get(books.size() - 1).getBookId() + 1;
        }
        book.setBookId(id);

        try (FileWriter fw = new FileWriter(file, true);
             PrintWriter pw = new PrintWriter(fw)) {

            String json = objectMapper.writeValueAsString(book);
            pw.println(json);
            return book;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Book updateBook(Book book) {
        List<Book> bookList = getAllBook();
        BookLinkedList bookLinkedList = new BookLinkedList();

        boolean isUpdated = false;

        for (Book b : bookList) {
            if (b.getBookId() == book.getBookId()) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
                b.setGenre(book.getGenre());
                b.setIsbn(book.getIsbn());
                b.setCoverPage(book.getCoverPage());
                b.setNoPages(book.getNoPages());
                b.setPrice(book.getPrice());
                b.setPublishedDate(book.getPublishedDate());
                isUpdated = true;
            }
            bookLinkedList.add(b);
        }

        if (isUpdated) {
            saveAllBooks(bookLinkedList.toList());
            return book;
        }

        return null;
    }

    @Override
    public Boolean deleteBook(int id) {
        List<Book> bookList = getAllBook();
        BookLinkedList bookLinkedList = new BookLinkedList();

        boolean isDeleted = false;

        for (Book b : bookList) {
            if (b.getBookId() != id) {
                bookLinkedList.add(b);
            } else {
                isDeleted = true;
            }
        }

        if (isDeleted) {
            saveAllBooks(bookLinkedList.toList());
            return true;
        }

        return false;
    }

    public void saveAllBooks(List<Book> books) {
        try (FileWriter fw = new FileWriter(file, false);
             PrintWriter pw = new PrintWriter(fw)) {

            for (Book book : books) {
                String json = objectMapper.writeValueAsString(book);
                pw.println(json);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
