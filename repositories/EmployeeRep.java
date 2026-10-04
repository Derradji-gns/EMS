package com.derradjiamine.Backend.repositories;


import com.derradjiamine.Backend.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRep extends JpaRepository<Employee, UUID> {


}
