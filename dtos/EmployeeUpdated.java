package com.derradjiamine.Backend.dtos;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record EmployeeUpdated(

        @NotNull(message = "First Name is required")
        @Size(min = 2, max = 50, message = "First Name should be between 2 and 50 characters")
        String FirstName,
        @NotNull (message = "Last Name is required")
        String LastName,
        @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
        String Phone,
        @PastOrPresent(message = "Hire date cannot be in the future")
        LocalDate hireDate  )
{


}
