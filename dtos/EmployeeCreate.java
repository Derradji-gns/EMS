package com.derradjiamine.Backend.dtos;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

public record EmployeeCreate(
        @NotNull(message = "First Name is required")
        @Size(min = 2, max = 50, message = "First Name should be between 2 and 50 characters")
            String FirstName,
        @NotNull (message = "Last Name is required")
            String LastName,
        @Email(message = "Email should be valid")
            String Email,
        @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
            String Phone,
        @PastOrPresent(message = "Hire date cannot be in the future")
            LocalDate hireDate,
            String position,
        @NotNull (message = "DepartementId is required")
        UUID departementId)
{


}
