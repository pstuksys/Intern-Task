package com.example.Java.Developer.Task.repository;

import com.example.Java.Developer.Task.model.Book;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;

@Repository
public interface BookRepository {

    Object filterByName(String name) throws FileNotFoundException;
    Object filterByAuthor(String author) throws FileNotFoundException;
    Object filterByCategory(String category) throws FileNotFoundException;
    Object filterByLanguage(String language) throws FileNotFoundException;
    Object filterByISBN(String ISBN) throws FileNotFoundException;
    Object filterByGUI(String GUI) throws FileNotFoundException;
}
