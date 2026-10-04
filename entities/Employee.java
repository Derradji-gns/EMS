package com.derradjiamine.Backend.entities;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;



/// those anotations will automatically generate the getters and setters for the class , also the constructor with all the parameters


@Entity
@Table (name = "Employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue (generator = "UUID")
    @UuidGenerator
    private UUID id;

    @Column (name = "First_name", nullable = false, length = 100)
    private String FirstName;

    @Column (name = "Last_name", nullable = false)
    private String LastName;

    @Column (name = "Email", nullable = false, unique = true)
    private String Email;

    @Column (name = "Phone", unique = true)
    private String Phone;

    @Column (name = "Hire_date", nullable = false)
    private LocalDate hireDate;

    @Column (name = "Position", nullable = false)
    private String position;

    @JsonProperty("department_id")
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn  (name = "Departement_id", nullable = false)
    private Departement departement;

    public UUID getDepartement() {
        return departement.getId();
    }
    public UUID getId() {
        return id;
    }
}

//// about the data validation we have to use contraints from "jakarta.validation.constraints" package to every field then use @Valid annotation in the specified controller