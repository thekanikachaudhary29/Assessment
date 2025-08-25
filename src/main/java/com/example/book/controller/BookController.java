package com.example.book.controller;

import com.example.book.dto.BookDto;
import com.example.book.entity.Book;
import com.example.book.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home() {
        return "Book API is running!";
    }

    //create books in library
    @PreAuthorize("Role('ADMIN','LIBRARIAN')")
    @PostMapping("/create")
    public ResponseEntity<Book> create(@Valid @RequestBody BookDto dto) {
      Book createdBook = bookService.add(dto);
      return ResponseEntity.ok(createdBook);
    }
}