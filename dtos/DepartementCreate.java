package com.derradjiamine.Backend.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DepartementCreate(
        @NotNull(message = "Departement Name is required")
        @Size(min = 2, max = 50, message = "Departement Name should be between 2 and 50 characters")
        String name
) {
}
