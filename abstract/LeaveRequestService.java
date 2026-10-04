package com.derradjiamine.Backend;

import java.util.List;
import java.util.UUID;
import com.derradjiamine.Backend.dtos.LeaveRequestCreate;
import com.derradjiamine.Backend.entities.LeaveRequest;



public abstract interface LeaveRequestService {
    LeaveRequest createOne(LeaveRequestCreate leaveRequestCreateest, UUID employeeId);
    List<LeaveRequest> findAll(UUID employeeId);
}