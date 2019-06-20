package com.example.demo.converter;

import com.example.demo.dto.AuthorDTO;
import com.example.demo.dto.BookAuthorDTO;
import com.example.demo.dto.BookDTO;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookConverter {

    public static Book getBook(BookDTO bookDTO) {

        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setName(bookDTO.getName());
        book.setDescription(bookDTO.getDescription());
        book.setDateCreation(bookDTO.getYear());
        return book;
    }

    public static Book getBook(BookAuthorDTO bookAuthorDTO) {

        Book book = new Book();
        book.setId(bookAuthorDTO.getId());
        book.setName(bookAuthorDTO.getName());
        book.setDescription(bookAuthorDTO.getDescription());
        book.setDateCreation(bookAuthorDTO.getYear());
        return book;
    }

    public static BookDTO getBookDTO(Book book) {

        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setDescription(book.getDescription());
        bookDTO.setYear(book.getDateCreation());
        bookDTO.setGenre(book.getGenre().getName());
        return bookDTO;
    }

    public static BookAuthorDTO getBookAuthorDTO(Book book) {

        BookAuthorDTO bookAuthorDTO = new BookAuthorDTO();
        bookAuthorDTO.setId(book.getId());
        bookAuthorDTO.setName(book.getName());
        bookAuthorDTO.setDescription(book.getDescription());
        bookAuthorDTO.setYear(book.getDateCreation());
        bookAuthorDTO.setGenre(book.getGenre().getName());

        List<Author> authorList = book.getAuthors();
        List<AuthorDTO> authorDTOList = new ArrayList<>(authorList.size());
        for (Author author : authorList) {
            authorDTOList.add(AuthorConverter.getAuthorDTO(author));
        }
        bookAuthorDTO.setAuthorDTOList(authorDTOList);
        return bookAuthorDTO;
    }
}
