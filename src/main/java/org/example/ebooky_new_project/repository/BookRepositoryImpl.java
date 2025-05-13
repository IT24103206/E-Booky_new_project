package org.example.ebooky_new_project.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ebooky_new_project.model.Book;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private File file = new File("book.txt");

    public BookRepositoryImpl() {
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
        List<Book> books = new LinkedList<>();
        try{
            ObjectMapper mapper = new ObjectMapper();

            if(file.exists() && file.length()>0){
                books = mapper.readValue(file, new TypeReference<List<Book>>() {});
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

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file,books);
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
                objectMapper.writeValue(file,bookList);
                return book;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean deleteBook(int Id) {
        List<Book> books = getAllBook();
        boolean isRemoved = false;
        try {
            // Remove book with matching ID
            for (Book b : books) {
                if (b.getBookId() == Id) {
                    books.remove(b);
                    isRemoved = true;
                    break;
                }
            }

            if (isRemoved) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(file, books);
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}