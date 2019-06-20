package com.example.demo.service;

import com.example.demo.entity.Genre;

import java.util.List;

public interface GenreService {

    Genre findOne(Long id);

    Genre findOneByName(String name);

    List<Genre> findAll();

    Genre save(Genre genre);

    void remove(Long id);
}
