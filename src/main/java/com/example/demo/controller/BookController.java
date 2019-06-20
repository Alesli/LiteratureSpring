package com.example.demo.controller;

import com.example.demo.dto.BookAuthorDTO;
import com.example.demo.dto.BookDTO;
import com.example.demo.facade.LibraryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private LibraryFacade libraryFacade;

    /*
     * http://localhost:8080/api/book/get/by/id/1
     */
    @GetMapping("/get/by/id/{bookId}")
    public ResponseEntity<BookDTO> findOneBookById(@PathVariable("bookId") Long bookId) {
        BookDTO result = libraryFacade.findOneBook(bookId);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * http://localhost:8080/api/book/get/by/name/{name}
     */
    @GetMapping("/get/by/name/{bookName}")
    public ResponseEntity<List<BookDTO>> findAllBooksByName(@PathVariable("bookName") String bookName) {
        List<BookDTO> result = libraryFacade.findAllBookByName(bookName);
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * http://localhost:8080/api/book/get/by/description/{description}
     */
    @GetMapping("/get/by/description/{description}")
    public ResponseEntity<List<BookDTO>> findAllBooksByDescription(@PathVariable("description") String description) {
        List<BookDTO> result = libraryFacade.findAllBookByDescription(description);
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * http://localhost:8080/api/book/get/by/genre/{genre}
     */
    @GetMapping("/get/by/genre/{genreName}")
    public ResponseEntity<List<BookDTO>> findAllBooksByGenre(@PathVariable("genreName") String genreName) {
        List<BookDTO> result = libraryFacade.findAllBookByGenre(genreName);
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * http://localhost:8080/api/book/author/get/by/name/{name}
     */
    @GetMapping("/author/get/by/name/{bookName}")
    public ResponseEntity<List<BookAuthorDTO>> findAllBooksAuthorByName(@PathVariable("bookName") String bookName) {
        List<BookAuthorDTO> result = libraryFacade.findAllBookAuthorByName(bookName);
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * http://localhost:8080/api/book/get/all
     */
    @GetMapping("/get/all")
    public ResponseEntity<List<BookDTO>> findAllBook() {
        List<BookDTO> result = libraryFacade.findAllBook();
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * http://localhost:8080/api/book/author/get/all
     */
    @GetMapping("/author/get/all")
    public ResponseEntity<List<BookAuthorDTO>> findAllBookAuthor() {
        List<BookAuthorDTO> result = libraryFacade.findAllBookAuthor();
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * пример сохранения книги с одним автором:
     *
      {
       "id": null,
       "name": "Ethical engineer",
       "year": 2018,
       "genre": "Фантастика",
       "description": "Книга про непримеримую войну долбозавра и норм поцана",
       "authorDTOList":
        [
         {
          "id":3,
          "name":"Harry",
          "lastName":"Harrison"
         }
        ]
      }
     *
     * с двумя:
     *
      {
       "id": null,
       "name": "Ethical engineer",
       "year": 2018,
       "genre": "Фантастика",
       "description": "Книга про непримеримую войну долбозавра и норм поцана",
       "authorDTOList":
        [
         {
          "id":2,
          "name":"Andrew",
          "lastName":"Norton"
         },
         {
          "id":3,
          "name":"Harry",
          "lastName":"Harrison"
         }
        ]
      }
     *
     */
    @PostMapping("/save")
    public ResponseEntity<BookAuthorDTO> saveBook(@RequestBody BookAuthorDTO bookAuthorDTO) {
        BookAuthorDTO result = libraryFacade.saveBook(bookAuthorDTO);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    /*
     * http://localhost:8080/api/book/remove/1
     */
    @GetMapping("/remove/{bookId}")
    public ResponseEntity removeBook(@PathVariable("bookId") Long bookId) {
        libraryFacade.removeBook(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
