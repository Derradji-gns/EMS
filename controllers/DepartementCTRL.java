package com.derradjiamine.Backend.controllers;

import com.derradjiamine.Backend.DepartementService;
import com.derradjiamine.Backend.dtos.DepartementCreate;
import com.derradjiamine.Backend.entities.Departement;
import com.derradjiamine.Backend.shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/departments")
public class DepartementCTRL {


    @Autowired
    private  DepartementService departementService;


    @GetMapping()
    public ResponseEntity<GlobalResponse<List<Departement>>> getAll() {
        List<Departement> departements = departementService.findAll();
        return new ResponseEntity<>(new GlobalResponse(departements), HttpStatus.OK);
    } /////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/{departementId}")
    public ResponseEntity<GlobalResponse<?>> findOne(@PathVariable UUID departementId) {

        Departement departement = departementService.findOne(departementId);

        return new ResponseEntity<>(new GlobalResponse<>(departement), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<GlobalResponse<Departement>> createOne(@RequestBody @Valid DepartementCreate departementCreate) {
        Departement departement1 = departementService.createOne(departementCreate);
        return new ResponseEntity<>(new GlobalResponse<>(departement1), HttpStatus.CREATED);
    }

    @DeleteMapping("/{departementId}")
    public ResponseEntity<GlobalResponse<String>> deleteOne(@PathVariable UUID departementId) {

        departementService.deleteOne(departementId);

        return new ResponseEntity<>(new GlobalResponse<>("opeartion successed"), HttpStatus.NO_CONTENT);
    }



}
