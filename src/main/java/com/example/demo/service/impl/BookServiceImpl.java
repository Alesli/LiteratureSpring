package com.example.demo.service.impl;

import com.example.demo.entity.Book;
import com.example.demo.entity.Genre;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.GenreRepository;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Book findOne(Long id) {
        return bookRepository.getOne(id);
    }

    @Override
    public List<Book> findAllByName(String name) {
        return bookRepository.findAllByNameContaining(name);
    }

    @Override
    public List<Book> findAllByDescription(String description) {
        return bookRepository.findAllByDescriptionContaining(description);
    }

    @Override
    public List<Book> findAllByGenre(String name) {
        Genre genre = genreRepository.findOneByName(name);
        return genre.getBooks();
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void remove(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }
    }
}
