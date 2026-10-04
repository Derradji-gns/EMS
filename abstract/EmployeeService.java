package com.derradjiamine.Backend;

import com.derradjiamine.Backend.dtos.EmployeeCreate;
import com.derradjiamine.Backend.dtos.EmployeeUpdated;
import com.derradjiamine.Backend.entities.Employee;
import com.derradjiamine.Backend.shared.GlobalResponse;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract interface EmployeeService {
    Employee getOne(UUID employeeId);
    List<Employee> getAll();
    Employee addOne(EmployeeCreate employee);
    List<Employee> deleteOne(UUID employeeId);
    Employee updateOne(UUID employeeId, EmployeeUpdated employee);
}