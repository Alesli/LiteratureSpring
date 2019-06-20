package com.example.demo.facade.impl;

import com.example.demo.converter.AuthorConverter;
import com.example.demo.converter.BookConverter;
import com.example.demo.converter.GenreConverter;
import com.example.demo.dto.*;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.entity.Genre;
import com.example.demo.facade.LibraryFacade;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class LibraryFacadeImpl implements LibraryFacade {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private GenreService genreService;

    //---

    @Override
    public AuthorDTO findOneAuthor(Long id) {
        Author author = authorService.findOne(id);
        return AuthorConverter.getAuthorDTO(author);
    }

    @Override
    public List<AuthorDTO> findAllAuthorByName(String authorName) {
        List<Author> authorList = authorService.findAllByName(authorName);
        List<AuthorDTO> authorDTOList = new ArrayList<>(authorList.size());
        for (Author author : authorList) {
            authorDTOList.add(AuthorConverter.getAuthorDTO(author));
        }
        return authorDTOList;
    }

    @Override
    public List<AuthorDTO> findAllAuthorByLastName(String authorLastName) {
        List<Author> authorList = authorService.findAllByLastName(authorLastName);
        List<AuthorDTO> authorDTOList = new ArrayList<>(authorList.size());
        for (Author author : authorList) {
            authorDTOList.add(AuthorConverter.getAuthorDTO(author));
        }
        return authorDTOList;
    }

    @Override
    public List<AuthorBookDTO> findAllAuthorBookByName(String authorName) {
        List<Author> authorList = authorService.findAllByName(authorName);
        List<AuthorBookDTO> authorBookDTOList = new ArrayList<>(authorList.size());
        for (Author author : authorList) {
            authorBookDTOList.add(AuthorConverter.getAuthorBookDTO(author));
        }
        return authorBookDTOList;
    }

    @Override
    public List<AuthorBookDTO> findAllAuthorBookByLastName(String authorLastName) {
        List<Author> authorList = authorService.findAllByLastName(authorLastName);
        List<AuthorBookDTO> authorBookDTOList = new ArrayList<>(authorList.size());
        for (Author author : authorList) {
            authorBookDTOList.add(AuthorConverter.getAuthorBookDTO(author));
        }
        return authorBookDTOList;
    }

    @Override
    public List<AuthorDTO> findAllAuthor() {
        List<Author> authorList = authorService.findAll();
        List<AuthorDTO> authorDTOList = new ArrayList<>(authorList.size());
        for (Author author : authorList) {
            authorDTOList.add(AuthorConverter.getAuthorDTO(author));
        }
        return authorDTOList;
    }

    @Override
    public List<AuthorBookDTO> findAllAuthorBook() {
        List<Author> authorList = authorService.findAll();
        List<AuthorBookDTO> authorBookDTOList = new ArrayList<>(authorList.size());
        for (Author author : authorList) {
            authorBookDTOList.add(AuthorConverter.getAuthorBookDTO(author));
        }
        return authorBookDTOList;
    }

    @Override
    public AuthorDTO saveAuthor(AuthorDTO authorDTO) {
        Author author = AuthorConverter.getAuthor(authorDTO);
        Author authorSaved = authorService.save(author);
        return AuthorConverter.getAuthorDTO(authorSaved);
    }

    @Override
    public AuthorBookDTO saveAuthor(AuthorBookDTO authorBookDTO) {
        Author author = AuthorConverter.getAuthor(authorBookDTO);
        Author authorSavedFirst = authorService.save(author);

        List<BookDTO> bookDTOList = authorBookDTO.getBookDTOList();
        List<Book> bookList = new ArrayList<>(bookDTOList.size());
        for (BookDTO bookDTO : bookDTOList) {
            Book book = BookConverter.getBook(bookDTO);
            book.setGenre(genreService.findOneByName(bookDTO.getGenre()));
            book.setAuthors(Collections.singletonList(authorSavedFirst));
            bookList.add(book);
        }
        authorSavedFirst.setBooks(bookList);
        Author authorSavedSecond = authorService.save(authorSavedFirst);
        return AuthorConverter.getAuthorBookDTO(authorSavedSecond);
    }

    @Override
    public void removeAuthor(Long id) {
        authorService.remove(id);
    }

    // ---

    @Override
    public BookDTO findOneBook(Long id) {
        Book book = bookService.findOne(id);
        return BookConverter.getBookDTO(book);
    }

    @Override
    public List<BookDTO> findAllBookByName(String bookName) {
        List<Book> bookList = bookService.findAllByName(bookName);
        List<BookDTO> bookDTOList = new ArrayList<>(bookList.size());
        for (Book book : bookList) {
            bookDTOList.add(BookConverter.getBookDTO(book));
        }
        return bookDTOList;
    }

    @Override
    public List<BookDTO> findAllBookByDescription(String description) {
        List<Book> bookList = bookService.findAllByDescription(description);
        List<BookDTO> bookDTOList = new ArrayList<>(bookList.size());
        for (Book book : bookList) {
            bookDTOList.add(BookConverter.getBookDTO(book));
        }
        return bookDTOList;
    }

    @Override
    public List<BookDTO> findAllBookByGenre(String genreName) {
        List<Book> bookList = bookService.findAllByGenre(genreName);
        List<BookDTO> bookDTOList = new ArrayList<>(bookList.size());
        for (Book book : bookList) {
            bookDTOList.add(BookConverter.getBookDTO(book));
        }
        return bookDTOList;
    }

    @Override
    public List<BookAuthorDTO> findAllBookAuthorByName(String bookName) {
        List<Book> bookList = bookService.findAllByName(bookName);
        List<BookAuthorDTO> bookAuthorDTOList = new ArrayList<>(bookList.size());
        for (Book book : bookList) {
            bookAuthorDTOList.add(BookConverter.getBookAuthorDTO(book));
        }
        return bookAuthorDTOList;
    }

    @Override
    public List<BookDTO> findAllBook() {
        List<Book> bookList = bookService.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>(bookList.size());
        for (Book book : bookList) {
            bookDTOList.add(BookConverter.getBookDTO(book));
        }
        return bookDTOList;
    }

    @Override
    public List<BookAuthorDTO> findAllBookAuthor() {
        List<Book> bookList = bookService.findAll();
        List<BookAuthorDTO> bookAuthorDTOList = new ArrayList<>(bookList.size());
        for (Book book : bookList) {
            bookAuthorDTOList.add(BookConverter.getBookAuthorDTO(book));
        }
        return bookAuthorDTOList;
    }

    @Override
    public BookAuthorDTO saveBook(BookAuthorDTO bookAuthorDTO) {
        Book book = BookConverter.getBook(bookAuthorDTO);
        List<AuthorDTO> authorDTOList = bookAuthorDTO.getAuthorDTOList();
        List<Author> authorList = new ArrayList<>(authorDTOList.size());
        for (AuthorDTO authorDTO : authorDTOList) {
            authorList.add(AuthorConverter.getAuthor(authorDTO));
        }
        book.setAuthors(authorList);
        book.setGenre(genreService.findOneByName(bookAuthorDTO.getGenre()));
        Book bookSaved = bookService.save(book);
        return BookConverter.getBookAuthorDTO(bookSaved);
    }

    @Override
    public void removeBook(Long id) {
        bookService.remove(id);
    }

    // ---

    @Override
    public GenreDTO findOneGenre(Long id) {
        Genre genre = genreService.findOne(id);
        return GenreConverter.getGenreDTO(genre);
    }

    @Override
    public GenreDTO findOneGenreByName(String genreName) {
        Genre genre = genreService.findOneByName(genreName);
        return GenreConverter.getGenreDTO(genre);
    }

    @Override
    public GenreBookDTO findGenreBookByName(String genreName) {
        Genre genre = genreService.findOneByName(genreName);
        return GenreConverter.getGenreBookDTO(genre);
    }

    @Override
    public List<GenreDTO> findAllGenre() {
        List<Genre> genreList = genreService.findAll();
        List<GenreDTO> genreDTOList = new ArrayList<>(genreList.size());
        for (Genre genre : genreList) {
            genreDTOList.add(GenreConverter.getGenreDTO(genre));
        }
        return genreDTOList;
    }

    @Override
    public GenreDTO saveGenre(GenreDTO genreDTO) {
        Genre genre = GenreConverter.getGenre(genreDTO);
        Genre genreSaved = genreService.save(genre);
        return GenreConverter.getGenreDTO(genreSaved);
    }

    @Override
    public void removeGenre(Long id) {
        genreService.remove(id);
    }
}
