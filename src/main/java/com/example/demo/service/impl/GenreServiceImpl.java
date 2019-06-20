package com.example.demo.service.impl;

import com.example.demo.entity.Genre;
import com.example.demo.repository.GenreRepository;
import com.example.demo.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre findOne(Long id) {
        return genreRepository.getOne(id);
    }

    @Override
    public Genre findOneByName(String name) {
        return genreRepository.findOneByName(name);
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void remove(Long id) {
        if (genreRepository.existsById(id)) {
            genreRepository.deleteById(id);
        }
    }
}
