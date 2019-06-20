package com.example.demo.converter;

import com.example.demo.dto.AuthorBookDTO;
import com.example.demo.dto.AuthorDTO;
import com.example.demo.dto.BookDTO;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class AuthorConverter {

    public static Author getAuthor(AuthorDTO authorDTO) {

        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        author.setLastName(authorDTO.getLastName());
        return author;
    }

    public static Author getAuthor(AuthorBookDTO authorBookDTO) {

        Author author = new Author();
        author.setId(authorBookDTO.getId());
        author.setName(authorBookDTO.getName());
        author.setLastName(authorBookDTO.getLastName());
        return author;
    }

    public static AuthorDTO getAuthorDTO(Author author) {

        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());
        authorDTO.setLastName(author.getLastName());
        return authorDTO;
    }

    public static AuthorBookDTO getAuthorBookDTO(Author author) {

        AuthorBookDTO authorBookDTO = new AuthorBookDTO();
        authorBookDTO.setId(author.getId());
        authorBookDTO.setName(author.getName());
        authorBookDTO.setLastName(author.getLastName());

        List<Book> bookList = author.getBooks();
        List<BookDTO> bookDTOList = new ArrayList<>(bookList.size());
        for (Book book : bookList) {
            bookDTOList.add(BookConverter.getBookDTO(book));
        }
        authorBookDTO.setBookDTOList(bookDTOList);
        return authorBookDTO;
    }
}
