package com.example.Java.Developer.Task.controller;

import com.example.Java.Developer.Task.model.Book;
import com.example.Java.Developer.Task.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping("/books")
    public Book getAllBooks() throws FileNotFoundException {
        return service.findAllBooks();
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) throws IOException {
        return service.addNewBook(book);
    }

    @GetMapping("/guid/{guid}")
    public Object findByGUI(@PathVariable("guid") String GUI) throws FileNotFoundException {
        return service.findBookByGui(GUI);
    }

    @DeleteMapping("/delete/{gui}")
    public void deleteBookByGui(@PathVariable("gui") String gui) throws FileNotFoundException {
         service.deleteBookByGui(gui);
    }



    @GetMapping("/names/{name}")
    public Object findByName(@PathVariable("name") String name) throws FileNotFoundException {
        return service.filterByName(name);
    }

    @GetMapping("/authors/{author}")
    public Object findByAuthor(@PathVariable("author") String author) throws FileNotFoundException {
        return service.filterByAuthor(author);
    }
    @GetMapping("/categories/{category}")
    public Object findByCategory(@PathVariable("category") String category) throws FileNotFoundException {
        return service.filterByCategory(category);
    }
    @GetMapping("/languages/{language}")
    public Object findByLanguage(@PathVariable("language") String language) throws FileNotFoundException {
        return service.filterByLanguage(language);
    }

    @GetMapping("/isbn/{isbn}")
    public Object findByISBN(@PathVariable("isbn") String ISBN) throws FileNotFoundException {
        return service.filterByLanguage(ISBN);
    }

}
