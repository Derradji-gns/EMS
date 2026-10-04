package com.derradjiamine.Backend;



import java.util.List;
import java.util.UUID;


import com.derradjiamine.Backend.dtos.DepartementCreate;
import com.derradjiamine.Backend.entities.Departement;
import com.derradjiamine.Backend.entities.Employee;
import com.derradjiamine.Backend.shared.GlobalResponse;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public abstract interface DepartementService {
    Departement findOne(UUID departementId);
    List<Departement> findAll();
    Departement createOne(DepartementCreate departementCreate);
    List<Departement> deleteOne(UUID departementId);
}