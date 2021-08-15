package com.books.booklist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.books.booklist.domain.Books;
import com.books.booklist.repository.BooksList;
import java.util.List;
import java.util.Optional;
//import java.util.ArrayList;
//import java.util.Optional;
        
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class BooksController {

  @Autowired
  BooksList booksRepository;

  @RequestMapping(value = "/books", method = RequestMethod.GET)
  public List<Books> getAllBooks() {
    return booksRepository.findAll();
  }


  @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	  public List<Books> getAllBooksById(@PathVariable("id") String id) {
	  return booksRepository.findBookById(id);
  }

  @PostMapping("/books")
  public ResponseEntity<Books> createBooks(@RequestBody Books books) {
    try {
      Books _books = booksRepository.save(new Books(books.getTitle(), books.getAuthor(), false, books.getDescription()));
      return new ResponseEntity<>(_books, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/books/{id}")
  public ResponseEntity<Books> updateBooks(@PathVariable("id") String id, @RequestBody Books books) {
    Optional<Books> booksData = booksRepository.findById(id);

    if (booksData.isPresent()) {
      Books _books = booksData.get();
      _books.setTitle(books.getTitle());
      _books.setAuthor(books.getAuthor());
      _books.setDescription(books.getDescription());
      return new ResponseEntity<>(booksRepository.save(_books), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/books/{id}")
  public void deleteBooks(@PathVariable String id) {
	  booksRepository.deleteById(id);
  }

  @GetMapping("/books/unread")
  public ResponseEntity<List<Books>> findByUnRead() {
    try {
      List<Books> books = booksRepository.findByUnread(false);

      if (books.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(books, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}


//1. GET /api/books (retruns the array of books).
//2. POST /api/books (create new book).
//3. GET /api/book/{_id} (get a book).
//4. PUT /api/books/{i_d} (update an exisiting book).
//5. DELETE /api/books/{_id} (delete an exisitng book).
