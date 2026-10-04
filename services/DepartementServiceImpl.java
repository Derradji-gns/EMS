package com.derradjiamine.Backend.services;

import com.derradjiamine.Backend.DepartementService;
import com.derradjiamine.Backend.dtos.DepartementCreate;
import com.derradjiamine.Backend.entities.Departement;
import com.derradjiamine.Backend.repositories.DepartementRep;
import com.derradjiamine.Backend.shared.CustomResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartementServiceImpl implements DepartementService {

    @Autowired
    private DepartementRep departementRep;


    @Override
    public Departement findOne(UUID departementId) {
        Departement departement = departementRep.findById(departementId)
        .orElseThrow(() -> CustomResponseException.ResourceNotFound("Departement not found !"));

        return departement;
    }

    @Override
    public List<Departement> findAll() {
        List<Departement> departements = departementRep.findAll();
        return departements;
    }

    @Override
    public Departement createOne(DepartementCreate departementCreate) {

        Departement departement = new Departement();
        departement.setId(UUID.randomUUID());
        departement.setName(departementCreate.name());
        departementRep.save(departement);
        return departement;
    }

    @Override
    public List<Departement> deleteOne(UUID departementId) {
        Optional<Departement> departement = departementRep.findById(departementId);
        departementRep.deleteById(departement.get().getId());
        return departementRep.findAll();
    }
}
