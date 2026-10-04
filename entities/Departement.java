package com.derradjiamine.Backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table (name = "departement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Departement {

    @Id
    @GeneratedValue (generator = "UUID")
    @UuidGenerator
    private UUID id;

    @Column(name = "name", nullable = false, unique = true, length = 70)
    private String name;
}
