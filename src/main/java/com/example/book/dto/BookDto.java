package com.example.book.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    @NotBlank(message = "Title is required")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;

    @NotBlank(message = "Author is required")
    @Size(min = 2, max = 50, message = "Author must be between 2 and 50 characters")
    private String author;

    @NotNull(message = "ISBN is required")
    @Digits(integer = 13, fraction = 0, message = "ISBN must be integer ")
    private Integer ISBN;

    @NotNull(message = "Category is required")
    private String category;

    @NotNull(message = "Year is required")
    private Date publishedYear;

    @NotBlank(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;
}