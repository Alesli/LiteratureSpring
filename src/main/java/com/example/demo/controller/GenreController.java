package com.example.demo.controller;

import com.example.demo.dto.GenreDTO;
import com.example.demo.facade.LibraryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController {

    @Autowired
    private LibraryFacade libraryFacade;

    /*
     * http://localhost:8080/api/genre/get/by/id/1
     */
    @GetMapping("/get/by/id/{genreId}")
    public ResponseEntity<GenreDTO> findOneGenreById(@PathVariable("genreId") Long genreId) {
        GenreDTO result = libraryFacade.findOneGenre(genreId);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * http://localhost:8080/api/genre/get/by/name/{name}
     */
    @GetMapping("/get/by/name/{ganreName}")
    public ResponseEntity<GenreDTO> finOneGenreByName(@PathVariable("ganreName") String ganreName) {
        GenreDTO result = libraryFacade.findOneGenreByName(ganreName);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * http://localhost:8080/api/genre/get/all
     */
    @GetMapping("/get/all")
    public ResponseEntity<List<GenreDTO>> finAllGenre() {
        List<GenreDTO> result = libraryFacade.findAllGenre();
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * пример:
     *
      {
      "id":null,
      "name":"Фантастика"
      }
     *
     */
    @PostMapping("/save")
    public ResponseEntity<GenreDTO> saveGenre(@RequestBody GenreDTO genreDTO) {
        GenreDTO result = libraryFacade.saveGenre(genreDTO);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * http://localhost:8080/api/genre/remove/1
     */
    @GetMapping("/remove/{genreId}")
    public ResponseEntity removeGenre(@PathVariable("genreId") Long genreId) {
        libraryFacade.removeGenre(genreId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
