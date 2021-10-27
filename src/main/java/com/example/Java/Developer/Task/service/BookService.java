package com.example.Java.Developer.Task.service;

import com.example.Java.Developer.Task.model.Book;
import com.example.Java.Developer.Task.repository.BookRepository;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.*;

@Service
public class BookService implements BookRepository {

    public Book findAllBooks() throws FileNotFoundException {
        Book gson = new Gson().fromJson(new FileReader("target/books.json"), Book.class);
        System.out.println("Finding all the books from the library");
        System.out.println(gson);
        return gson;
    }

    public Book addNewBook(Book book) throws IOException {

        book.setName(book.getName());
        book.setAuthor(book.getAuthor());
        book.setLanguage(book.getLanguage());
        book.setCategory(book.getCategory());
        book.setPublicationDate(book.getPublicationDate());
        book.setISBN(UUID.randomUUID().toString());
        book.setGUID(book.getGUID());

        Gson gson = new Gson();
        String json = gson.toJson(book);
        try (FileWriter writer = new FileWriter("target/books.json")) {
            gson.toJson(book, writer);
            System.out.println("Book has been Added to the library");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return book;
    }

    public Object findBookByGui(String gui) throws FileNotFoundException {
        Book gson = new Gson().fromJson(new FileReader("target/books.json"), Book.class);
        if (gson.getGUID().equals(gui)) {
            System.out.println("Finding book by GUI: " + gui);
            System.out.println(gson);
            return gson;
        } else {
            return "Book With GUI: " + gui + " was not found";
        }
    }

    public void deleteBookByGui(String guid) throws FileNotFoundException {
        Book gson = new Gson().fromJson(new FileReader("target/books.json"), Book.class);
        //String exists = gson.getGUID();

        if (gson.getGUID().equals(guid)){
            gson = null;
            System.gc();
        }

    }

    @Override
    public Object filterByName(String name) throws FileNotFoundException {
        Book gson = new Gson().fromJson(new FileReader("target/books.json"), Book.class);
        if (gson.getName().equals(name)) {
//            return gson.getName();
            return gson;
        }else{
            return "Book with name: " + name +" Not Found";
        }
    }

    @Override
    public Object filterByAuthor(String author) throws FileNotFoundException {
        Book gson = new Gson().fromJson(new FileReader("target/books.json"), Book.class);
        if (gson.getAuthor().equals(author)) {
            return gson;
        }else{
            return "Book by author: " + author +" Not Found";
        }
    }

    @Override
    public Object filterByCategory(String category) throws FileNotFoundException {
        Book gson = new Gson().fromJson(new FileReader("target/books.json"), Book.class);
        if (gson.getCategory().equals(category)) {
            return gson;
        }else{
            return "Books with category: " + category +" Not Found";
        }
    }

    @Override
    public Object filterByLanguage(String language) throws FileNotFoundException {
        Book gson = new Gson().fromJson(new FileReader("target/books.json"), Book.class);
        if (gson.getLanguage().equals(language)) {
            return gson;
        }else{
            return "Books by language: " + language + " Not Found";
        }
    }

    @Override
    public Object filterByISBN(String ISBN) throws FileNotFoundException {
        Book gson = new Gson().fromJson(new FileReader("target/books.json"), Book.class);
        if (gson.getISBN().equals(ISBN)) {
            return gson;
        }else{
            return "Book by ISBN: " + ISBN + "Was Not Found";
        }
    }

    @Override
    public Object filterByGUI(String GUI) throws FileNotFoundException {
        return null;
    }


    //    public Collection<Book> addNewBook(Book book) throws IOException {
//        Gson gson = new Gson();
//
//        Collection<Book> books = new ArrayList<>();
//        book.setName(book.getName());
//        book.setAuthor(book.getAuthor());
//        book.setLanguage(book.getLanguage());
//        book.setCategory(book.getCategory());
//        book.setPublicationDate(book.getPublicationDate());
//        book.setISBN(UUID.randomUUID().toString());
//        book.setGUID(book.getGUID());
//        books.add(book);
//
//        String json = gson.toJson(books);
//
//        try (FileWriter writer = new FileWriter("target/books.json")) {
//            gson.toJson(books, writer);
//            System.out.println("Book has been Added to the library");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////        JsonArray array = JsonParser.parseString(json).getAsJsonArray();
//        return books;
//    }
}
