package com.zagradio.me.zagradio_me_back.rest.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UserCreateDto(
        @Email(message = "Email should be valid")
        @NotBlank(message = "Email is mandatory")
        String email,

        @NotBlank(message = "First name is mandatory")
        String firstName,

        @NotBlank(message = "Last name is mandatory")
        String lastName,

        @Past(message = "Date of birth must be a past date")
        LocalDate dateOfBirth,

        @Size(min = 6, message = "Password should have at least 6 characters")
        String password
) {
}
