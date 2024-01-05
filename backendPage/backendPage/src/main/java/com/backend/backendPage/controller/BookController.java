package com.backend.backendPage.controller;

import com.backend.backendPage.model.Book;
import com.backend.backendPage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// BookController.java
@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:4200")

public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> list = bookService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Book>  deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        Book book = bookService.findBook(id);
        if(book == null) return new ResponseEntity<>(null, HttpStatus.OK);

        else return new ResponseEntity<>(book, HttpStatus.OK);

    }



}
