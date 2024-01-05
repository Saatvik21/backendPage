package com.backend.backendPage.service;

import com.backend.backendPage.model.Book;
import com.backend.backendPage.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// BookService.java
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book findBook(Long id){
        return bookRepository.findById(id).orElse(null);
    }

}

