package com.example.demo.controller;

import com.example.demo.dto.AuthorBookDTO;
import com.example.demo.dto.AuthorDTO;
import com.example.demo.facade.LibraryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private LibraryFacade libraryFacade;

    /*
     * http://localhost:8080/api/author/get/by/id/1
     */
    @GetMapping("/get/by/id/{authorId}")
    public ResponseEntity<AuthorDTO> findOneById(@PathVariable("authorId") Long authorId) {
        AuthorDTO result = libraryFacade.findOneAuthor(authorId);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * http://localhost:8080/api/author/get/by/name/Andrew
     */
    @GetMapping("/get/by/name/{name}")
    public ResponseEntity<List<AuthorDTO>> findAllByName(@PathVariable("name") String name) {
        List<AuthorDTO> result = libraryFacade.findAllAuthorByName(name);
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * http://localhost:8080/api/author/get/by/lastName/Norton
     */
    @GetMapping("/get/by/lastName/{lastName}")
    public ResponseEntity<List<AuthorDTO>> findAllByLastName(@PathVariable("lastName") String lastName) {
        List<AuthorDTO> result = libraryFacade.findAllAuthorByLastName(lastName);
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * http://localhost:8080/api/author/book/get/by/name/Andrew
     */
    @GetMapping("/book/get/by/name/{name}")
    public ResponseEntity<List<AuthorBookDTO>> findAllBookByName(@PathVariable("name") String name) {
        List<AuthorBookDTO> result = libraryFacade.findAllAuthorBookByName(name);
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * http://localhost:8080/api/author/book/get/by/lastName/Norton
     */
    @GetMapping("/book/get/by/lastName/{lastName}")
    public ResponseEntity<List<AuthorBookDTO>> findAllBookByLastName(@PathVariable("lastName") String lastName) {
        List<AuthorBookDTO> result = libraryFacade.findAllAuthorBookByLastName(lastName);
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * http://localhost:8080/api/author/get/all
     */
    @GetMapping("/get/all")
    public ResponseEntity<List<AuthorDTO>> findAll() {
        List<AuthorDTO> result = libraryFacade.findAllAuthor();
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * http://localhost:8080/api/author/book/get/all
     */
    @GetMapping("/book/get/all")
    public ResponseEntity<List<AuthorBookDTO>> findAllBook() {
        List<AuthorBookDTO> result = libraryFacade.findAllAuthorBook();
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * пример без книг:
     *
      {
      "id":null,
      "name":"Андре",
      "lastName":"Нортон"
      }
     *
     */
    @PutMapping("/save")
    public ResponseEntity<AuthorDTO> save(@RequestBody AuthorDTO authorDTO) {
        AuthorDTO result = libraryFacade.saveAuthor(authorDTO);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * пример с одной книгой:
     *
      {
       "id":null,
       "name":"Poul",
       "lastName":"Anderson",
       "bookDTOList":
        [
         {
          "id":null,
          "name":"The Stars Are Also Fire",
          "year":1994,
          "genre":"Фантастика",
          "description":"The Stars Are Also Fire"
         }
        ]
      }
     *
     * пример с двумя книгами:
     *
      {
       "id":null,
       "name":"Isaac",
       "lastName":"Asimov",
       "bookDTOList":
        [
         {
          "id":null,
          "name":"The Bicentennial Man",
          "year":1976,
          "genre":"Фантастика",
          "description":"Двухсотлетний человек"
         },
         {
         "id":null,
          "name":"I, Robot",
          "year":1950,
          "genre":"Фантастика",
          "description":"Сборник научно-фантастических рассказов Айзека Азимова, опубликованный в 1950 году американским издательством Gnome Press и оказавший большое влияние на современную научно-фантастическую литературу. В данном сборнике впервые были сформулированы Три закона роботехники"
         }
        ]
      }
     *
     */
    @PostMapping("/save")
    public ResponseEntity<AuthorBookDTO> save(@RequestBody AuthorBookDTO authorBookDTO) {
        AuthorBookDTO result = libraryFacade.saveAuthor(authorBookDTO);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * http://localhost:8080/api/author/remove/1
     */
    @GetMapping("/remove/{authorId}")
    public ResponseEntity remove(@PathVariable("authorId") Long authorId) {
        libraryFacade.removeAuthor(authorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
