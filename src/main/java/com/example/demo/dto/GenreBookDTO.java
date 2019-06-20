package com.example.demo.dto;

import java.util.List;

public class GenreBookDTO {

    private Long id;
    private String name;
    private List<BookDTO> bookDTOList;

    public GenreBookDTO() {
    }

    public GenreBookDTO(Long id, String name, List<BookDTO> bookDTOList) {
        this.id = id;
        this.name = name;
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

    public List<BookDTO> getBookDTOList() {
        return bookDTOList;
    }

    public void setBookDTOList(List<BookDTO> bookDTOList) {
        this.bookDTOList = bookDTOList;
    }
}
