package com.example.demo.converter;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.GenreBookDTO;
import com.example.demo.dto.GenreDTO;
import com.example.demo.entity.Book;
import com.example.demo.entity.Genre;

import java.util.ArrayList;
import java.util.List;

public class GenreConverter {

    public static Genre getGenre(GenreDTO genreDTO) {

        Genre genre = new Genre();
        genre.setId(genreDTO.getId());
        genre.setName(genreDTO.getName());
        return genre;
    }

    public static GenreDTO getGenreDTO(Genre genre) {

        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(genre.getId());
        genreDTO.setName(genre.getName());
        return genreDTO;
    }

    public static GenreBookDTO getGenreBookDTO(Genre genre) {

        GenreBookDTO genreBookDTO = new GenreBookDTO();
        genreBookDTO.setId(genre.getId());
        genreBookDTO.setName(genre.getName());

        List<Book> bookList = genre.getBooks();
        List<BookDTO> bookDTOList = new ArrayList<>(bookList.size());
        for (Book book : bookList) {
            bookDTOList.add(BookConverter.getBookDTO(book));
        }
        genreBookDTO.setBookDTOList(bookDTOList);
        return genreBookDTO;
    }
}
