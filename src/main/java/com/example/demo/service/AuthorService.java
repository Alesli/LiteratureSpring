package com.example.demo.service;

import com.example.demo.entity.Author;

import java.util.List;

public interface AuthorService {

    Author findOne(Long id);

    List<Author> findAllByName(String name);

    List<Author> findAllByLastName(String lastName);

    List<Author> findAll();

    Author save(Author author);

    void remove(Long id);
}
