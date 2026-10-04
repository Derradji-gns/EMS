package com.derradjiamine.Backend.services;
import com.derradjiamine.Backend.EmployeeService;
import com.derradjiamine.Backend.dtos.EmployeeCreate;
import com.derradjiamine.Backend.dtos.EmployeeUpdated;
import com.derradjiamine.Backend.entities.Departement;
import com.derradjiamine.Backend.entities.Employee;
import com.derradjiamine.Backend.repositories.DepartementRep;
import com.derradjiamine.Backend.repositories.EmployeeRep;
import com.derradjiamine.Backend.shared.CustomResponseException;
import com.derradjiamine.Backend.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRep employeeRep;

    @Autowired
    private DepartementRep departementRep;

    @Autowired
    private SecurityUtils securityUtils;

    @Override
    @PreAuthorize("@securityUtils.isOwner(#employeeId)")
    public Employee getOne(UUID employeeId) {
        Optional<Employee> employee = employeeRep.findById(employeeId);
        if (employee.isPresent() == false) {
            throw  CustomResponseException.ResourceNotFound("Employee not found !");
        }
        return employee.get();
    }



    @Override
    public Employee addOne(EmployeeCreate employeeCreated) {

        Departement departement = departementRep.findById(employeeCreated.departementId())
                .orElseThrow(() -> CustomResponseException.ResourceNotFound("Departement not found !"));

        Employee employee = new Employee();
        employee.setId(UUID.randomUUID());
        employee.setFirstName(employeeCreated.FirstName());
        employee.setLastName(employeeCreated.LastName());
        employee.setEmail(employeeCreated.Email());
        employee.setPhone(employeeCreated.Phone());
        employee.setHireDate(employeeCreated.hireDate());
        employee.setPosition(employeeCreated.position());
        employee.setDepartement(departement);
        employeeRep.save(employee);
        return employee;
    }



    @Override
    public List<Employee> getAll() {
        List<Employee> employees = employeeRep.findAll();
        return employees;
    }


    @Override
    public List<Employee> deleteOne(UUID employeeId) {
        Optional<Employee> employee = employeeRep.findById(employeeId);

        if (employee.isPresent() == false) {
            throw  CustomResponseException.ResourceNotFound("employee with id " + employeeId + " not found");
        }

        employeeRep.deleteById(employee.get().getId());
        return employeeRep.findAll();
    }


    @Override
    public Employee updateOne(UUID employeeId, EmployeeUpdated employee) {
        Optional<Employee> existingEmployee = employeeRep.findById(employeeId);

        Employee updatedEmployee = existingEmployee.get();

        updatedEmployee.setFirstName(employee.FirstName());
        updatedEmployee.setLastName(employee.LastName());
        updatedEmployee.setPhone(employee.Phone());

        return updatedEmployee;

    }
}
