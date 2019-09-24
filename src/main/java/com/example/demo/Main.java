package com.example.demo;

import com.example.demo.entity.Author;
import com.example.demo.service.AuthorService;
import com.example.demo.service.impl.AuthorServiceImpl;

public class Main {
    public static void main(String[] args) {
        AuthorService authorService = new AuthorServiceImpl();
        Author author = authorService.findOne(1L);
        System.out.println(author);
    }
}
