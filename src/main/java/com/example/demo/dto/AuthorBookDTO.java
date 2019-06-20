package com.example.demo.dto;

import java.util.List;

public class AuthorBookDTO {

    private Long id;
    private String name;
    private String lastName;
    private List<BookDTO> bookDTOList;

    public AuthorBookDTO() {
    }

    public AuthorBookDTO(Long id, String name, String lastName, List<BookDTO> bookDTOList) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.bookDTOList = bookDTOList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<BookDTO> getBookDTOList() {
        return bookDTOList;
    }

    public void setBookDTOList(List<BookDTO> bookDTOList) {
        this.bookDTOList = bookDTOList;
    }
}
