package com.example.demo.service;

import com.example.demo.entity.Book;

import java.util.List;

public interface BookService {

    Book findOne(Long id);

    List<Book> findAllByName(String name);

    List<Book> findAllByDescription(String description);

    List<Book> findAllByGenre(String name);

    List<Book> findAll();

    Book save(Book book);

    void remove(Long id);
}
