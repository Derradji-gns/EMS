package com.derradjiamine.Backend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table (name = "Leave_request")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeaveRequest {
    @Id
    @GeneratedValue(generator = "UUID")
    @UuidGenerator
    private UUID id;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end-date", nullable = false)
    private LocalDate endDate;

    @Column (name = "Email", nullable = false, unique = true)
    private String Email;

    @Column (name = "reason", columnDefinition = "TEXT")
    private String reason;

    @Column (name = "status", nullable = false, length = 50)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employeeID", nullable = false)
    private Employee employee;

    public UUID getEmployee() {
        return employee.getId();
    }
}
