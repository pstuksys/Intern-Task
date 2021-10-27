package com.example.Java.Developer.Task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data @AllArgsConstructor @NoArgsConstructor
public class Book   {

    private String name;
    private String author;
    private String language;
    private String category;
    private String publicationDate;
    private String ISBN;
    private String GUID;

}
