package com.example.book.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "User name is must")
    @Size(min= 1, max = 50, message = "Name must be 1 to 50 characters")
    private String userName;

    @NotBlank(message = "Password is must")
    @Size(min = 8, max = 20, message = "Password must be between 8-20 characters ")
    @Schema(example = "librarian1")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).*$" , message = "Password must contain at least one digit, one lowercase, one uppercase, and one special character")
    private String password;

    @NotNull(message = "Contact Number is must")
   // @Pattern(regexp = "^(?=[0-9])" , message = "Contact Number must contain 10 digits number")
    @Digits(integer = 10, fraction = 0, message = "Contact number must be a 10 digit number")
    private Long contactNumber;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;
}