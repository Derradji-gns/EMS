package com.derradjiamine.Backend.dtos;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

public record LeaveRequestCreate (
        @NotNull(message = "First Name is required")
        @PastOrPresent(message = "start date cannot be in the future")
        LocalDate startDate,
        @NotNull (message = "Last Name is required")
        @FutureOrPresent(message = "End date cannot be in the past")
        LocalDate endDate,
        @Email(message = "Email should be valid")
        String Email,
        @NotNull(message = "status cannot be empty")
        @Size(min = 10, max = 120, message = "")
        String reason
) {
}
