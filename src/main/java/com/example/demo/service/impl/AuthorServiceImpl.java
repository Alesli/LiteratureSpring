package com.example.demo.service.impl;

import com.example.demo.entity.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author findOne(Long id) {
        return authorRepository.getOne(id);
    }

    @Override
    public List<Author> findAllByName(String name) {
        return authorRepository.findAllByName(name);
    }

    @Override
    public List<Author> findAllByLastName(String lastName) {
        return authorRepository.findAllByLastName(lastName);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void remove(Long id) {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
        }
    }
}
