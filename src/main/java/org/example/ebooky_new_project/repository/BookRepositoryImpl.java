package org.example.ebooky_new_project.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ebooky_new_project.model.Book;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository{

    private File file = new File("book.txt");
    private final ObjectMapper objectMapper;

    public BookRepositoryImpl(){
        this.objectMapper = new ObjectMapper();
        objectMapper.activateDefaultTyping(
                objectMapper.getPolymorphicTypeValidator(),
                ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT,
                JsonTypeInfo.As.PROPERTY
        );
        if(!file.exists()){
            try {
                file.createNewFile();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> books = new LinkedList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null) {
                Book book = objectMapper.readValue(line, Book.class);
                books.add(book);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return books;
    }

    @Override
    public Book saveBook(Book book) {
        List<Book> books = getAllBook();
        int id = 1;
        if(books.size()>0){
            id = books.get(books.size()-1).getBookId()+1;
        }
        book.setBookId(id);
        books.add(book);

        try(FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw)){

            String json = objectMapper.writeValueAsString(book);
            pw.println(json);
            return book;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Book updateBook(Book book) {
        List<Book> bookList = getAllBook();
        boolean isFind = false;
        try{

            ObjectMapper objectMapper = new ObjectMapper();

            for (Book b:bookList){
                if(b.getBookId() == book.getBookId()){
                    b.setTitle(book.getTitle());
                    b.setAuthor(book.getAuthor());
                    b.setGenre(book.getGenre());
                    b.setIsbn(book.getIsbn());
                    b.setCoverPage(book.getCoverPage());
                    b.setNoPages(book.getNoPages());
                    b.setPrice(book.getPrice());
                    b.setPublishedDate(book.getPublishedDate());
                    isFind = true;
                    break;
                }
            }
            if(isFind){
                saveAllBooks(bookList);
                return book;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean deleteBook(int id) {
        List<Book> books = getAllBook();
        boolean isRemoved = false;
        try {
            // Remove book with matching ID
            for (Book b : books) {
                if (b.getBookId() == id) {
                    books.remove(b);
                    isRemoved = true;
                    break;
                }
            }

            if (isRemoved) {
                saveAllBooks(books);
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void saveAllBooks(List<Book> books) {
        try (FileWriter fw = new FileWriter(file, false);
             PrintWriter pw = new PrintWriter(fw)) {

            for (Book book :books) {
                String json = objectMapper.writeValueAsString(book);
                pw.println(json);  // Write each user on a new line
            }

            System.out.println("All users saved successfully!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
