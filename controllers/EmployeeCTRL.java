package com.derradjiamine.Backend.controllers;
/// always use the package name as the first line of the class file

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.derradjiamine.Backend.EmployeeService;
import com.derradjiamine.Backend.dtos.EmployeeCreate;
import com.derradjiamine.Backend.dtos.EmployeeUpdated;
import com.derradjiamine.Backend.dtos.LeaveRequestCreate;
import com.derradjiamine.Backend.LeaveRequestService;
import com.derradjiamine.Backend.entities.LeaveRequest;
import com.derradjiamine.Backend.services.EmployeeServiceImpl;
import com.derradjiamine.Backend.shared.GlobalResponse;
import com.derradjiamine.Backend.shared.CustomResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.derradjiamine.Backend.entities.Employee;

import jakarta.validation.Valid;


@RestController
/// to specify this class as a controller class
@RequestMapping()
public class EmployeeCTRL {

    /// / we can use this also
    ///

    ///  tsama soit tzidlha annotation @Autowired wala tdirlha constructor

    /// / we did a constructor injection here

       @Autowired
       private EmployeeService  employeeService;



    @Autowired
    private LeaveRequestService leaveRequestService;
    

    /// get request
    ///
    @GetMapping("/Employees")
    public ResponseEntity<GlobalResponse<List<Employee>>> getAll() {
        List<Employee> employees = employeeService.getAll();
        return new ResponseEntity<>(new GlobalResponse(employees), HttpStatus.OK);
    } /////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/{employeeId}")
    /// to specifiy the "employeeId" in the url of request
    public ResponseEntity<GlobalResponse<?>> getOne(@PathVariable UUID employeeId) {
        //// here controller contacts the service
        Employee employee = employeeService.getOne(employeeId);

          return new ResponseEntity<>(new GlobalResponse<>(employee), HttpStatus.OK);
    } 

    @PostMapping("/Employees")
    public ResponseEntity<GlobalResponse<Employee>> addOne(@RequestBody @Valid EmployeeCreate employee) {
        Employee employee1 = employeeService.addOne(employee);
        return new ResponseEntity<>(new GlobalResponse<>(employee1), HttpStatus.CREATED);
    }


    @DeleteMapping("/{employeeId}")
     public ResponseEntity<GlobalResponse<String>> deleteOne(@PathVariable UUID employeeId) {

        employeeService.deleteOne(employeeId);
        
        return new ResponseEntity<>(new GlobalResponse<>("opeartion successed"), HttpStatus.NO_CONTENT);
     }

     @PutMapping("/{employeeID}")
     public ResponseEntity<GlobalResponse<Employee>> updateOne(@PathVariable UUID employeeId, @RequestBody @Valid EmployeeUpdated employee) {
        Employee updatedEmployee = employeeService.updateOne(employeeId, employee);

        return new ResponseEntity<>(new GlobalResponse<>(updatedEmployee), HttpStatus.CREATED);
     }

    @PostMapping("/{employeeId}/LeaveRequest")
    public ResponseEntity<GlobalResponse<LeaveRequest>>
    leaveRequest(@RequestBody @Valid LeaveRequestCreate leaveRequestCreate,
                                                                 @PathVariable UUID employeeId) {
        return new ResponseEntity<>(new GlobalResponse<>(leaveRequestService.createOne(leaveRequestCreate, employeeId)),
                HttpStatus.CREATED);
    }

    @GetMapping("/{employeeId}/LeaveRequest")
    public ResponseEntity<GlobalResponse<List<LeaveRequest>>>
    leaveRequestByEmployeeId(@PathVariable UUID employeeId) {
        List<LeaveRequest> leaveRequests = leaveRequestService.findAll(employeeId);
        return new ResponseEntity<>(new GlobalResponse<>(leaveRequests), HttpStatus.CREATED);
    }


    
}

