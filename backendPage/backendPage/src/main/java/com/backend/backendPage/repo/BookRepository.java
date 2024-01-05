package com.backend.backendPage.repo;

import com.backend.backendPage.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
