package com.example.book.controller;

import com.example.book.dto.BookDto;
import com.example.book.entity.Book;
import com.example.book.entity.User;
import com.example.book.service.BookService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @Test
   public void create() {
        BookDto dto = new BookDto();
        dto.setAuthor("K");
        dto.setCategory("Ank");
        dto.setTitle("QS");
        dto.setISBN(23);
        dto.setQuantity(1);
        dto.setPublishedYear(new Date());
        Book book = new Book();
        book.setTitle("Kan");
        book.setISBN(233223);
        book.setCategory("ABN");
        book.setAuthor("mad");
        book.setPublishedYear(new Date());
        book.setQuantity(1);
        Mockito.when(bookService.add(any())).thenReturn(book);
        Book response = bookService.add(dto);
        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Kan", response.getTitle());
    }
}
