package com.example.demo.dto;

public class BookDTO {

    private Long id;
    private String name;
    private int year;
    private String genre;
    private String description;

    public BookDTO() {
    }

    public BookDTO(Long id, String name, int year, String genre, String description) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.description = description;
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
}
