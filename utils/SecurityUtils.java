package com.derradjiamine.Backend.utils;

import com.derradjiamine.Backend.repositories.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SecurityUtils {

    @Autowired
    private UserAccountRepo userAccountRepo;
    public boolean isOwner(UUID incomingEmployeeId) {
        return true;
    }
}
