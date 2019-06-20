package com.example.demo.facade;

import com.example.demo.dto.*;

import java.util.List;

public interface LibraryFacade {

    // ---

    AuthorDTO findOneAuthor(Long id);

    List<AuthorDTO> findAllAuthorByName(String authorName);

    List<AuthorDTO> findAllAuthorByLastName(String authorLastName);

    List<AuthorBookDTO> findAllAuthorBookByName(String authorName);

    List<AuthorBookDTO> findAllAuthorBookByLastName(String authorLastName);

    List<AuthorDTO> findAllAuthor();

    List<AuthorBookDTO> findAllAuthorBook();

    AuthorDTO saveAuthor(AuthorDTO authorDTO);

    AuthorBookDTO saveAuthor(AuthorBookDTO authorBookDTO);

    void removeAuthor(Long id);

    // ---

    BookDTO findOneBook(Long id);

    List<BookDTO> findAllBookByName(String bookName);

    List<BookDTO> findAllBookByDescription(String description);

    List<BookDTO> findAllBookByGenre(String genreName);

    List<BookAuthorDTO> findAllBookAuthorByName(String bookName);

    List<BookDTO> findAllBook();

    List<BookAuthorDTO> findAllBookAuthor();

    BookAuthorDTO saveBook(BookAuthorDTO bookAuthorDTO);

    void removeBook(Long id);

    // ---

    GenreDTO findOneGenre(Long id);

    GenreDTO findOneGenreByName(String genreName);

    GenreBookDTO findGenreBookByName(String genreName);

    List<GenreDTO> findAllGenre();

    GenreDTO saveGenre(GenreDTO genreDTO);

    void removeGenre(Long id);
}
