package com.derradjiamine.Backend.services;

import com.derradjiamine.Backend.LeaveRequestService;
import com.derradjiamine.Backend.dtos.LeaveRequestCreate;
import com.derradjiamine.Backend.entities.LeaveRequest;
import com.derradjiamine.Backend.repositories.LeaveRequestRepo;
import com.derradjiamine.Backend.shared.CustomResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

    @Autowired
    private LeaveRequestRepo leaveRequestRepo;

    @Override
    public LeaveRequest createOne(LeaveRequestCreate leaveRequestCreate, UUID employeeId) {

        LeaveRequest leaveRequestConcern = leaveRequestRepo.findById(employeeId)
                .orElseThrow(() -> CustomResponseException.ResourceNotFound("Leave_Request not found !"));

        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setStatus("Pending");
        leaveRequest.setReason(leaveRequestCreate.reason());
        leaveRequest.setEmail(leaveRequestCreate.Email());
        leaveRequest.setStartDate(leaveRequestCreate.startDate());
        leaveRequest.setEndDate(leaveRequestCreate.endDate());

        leaveRequestRepo.save(leaveRequestConcern);

        return leaveRequest;
    }

    @Override
    public List<LeaveRequest> findAll(UUID employeeId) {
        return leaveRequestRepo.findAllByEmployeeId(employeeId);
    }
}
