package com.example.book.service;

import com.example.book.dto.BookDto;
import com.example.book.entity.Book;
import com.example.book.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book add(@Valid BookDto dto) {
        Book add = new Book();
        add.setAuthor(dto.getTitle());
        add.setISBN(dto.getISBN());
        add.setCategory(dto.getCategory());
        add.setQuantity(dto.getQuantity());
        add.setTitle(dto.getTitle());
        Book books = repository.save(add);
        return books;
    }
}
