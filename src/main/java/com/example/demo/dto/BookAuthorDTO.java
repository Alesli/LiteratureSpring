package com.example.demo.dto;

import java.util.List;

public class BookAuthorDTO {

    private Long id;
    private String name;
    private int year;
    private String genre;
    private String description;
    private List<AuthorDTO> authorDTOList;

    public BookAuthorDTO() {
    }

    public BookAuthorDTO(Long id, String name, int year, String genre, String description, List<AuthorDTO> authorDTOList) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.description = description;
        this.authorDTOList = authorDTOList;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AuthorDTO> getAuthorDTOList() {
        return authorDTOList;
    }

    public void setAuthorDTOList(List<AuthorDTO> authorDTOList) {
        this.authorDTOList = authorDTOList;
    }
}
