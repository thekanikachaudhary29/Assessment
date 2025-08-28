package com.example.book.service;

import com.example.book.dto.BookDto;
import com.example.book.entity.Book;
import com.example.book.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void addTest() {
        BookDto dto = new BookDto();
        dto.setTitle("Kan");
        dto.setISBN(233223);
        dto.setCategory("ABN");
        dto.setAuthor("mad");
        dto.setPublishedYear(new Date());
        dto.setQuantity(1);
        Book book = new Book();
        book.setTitle("Kan");
        book.setId(2L);
        book.setISBN(233223);
        book.setCategory("ABN");
        book.setAuthor("mad");
        book.setPublishedYear(new Date());
        book.setQuantity(1);
        Mockito.when(bookRepository.save(any())).thenReturn(book);
        Book response = bookService.add(dto);
        assertNotNull(response);
        assertEquals(2L, response.getId());
        assertEquals("Kan", response.getTitle());
    }
}
