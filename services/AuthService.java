package com.derradjiamine.Backend.services;

import com.derradjiamine.Backend.config.JwtHelper;
import com.derradjiamine.Backend.dtos.LoginRequest;
import com.derradjiamine.Backend.dtos.SignupRequest;
import com.derradjiamine.Backend.entities.Employee;
import com.derradjiamine.Backend.entities.UserAccount;
import com.derradjiamine.Backend.repositories.EmployeeRep;
import com.derradjiamine.Backend.repositories.UserAccountRepo;
import com.derradjiamine.Backend.shared.CustomResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class AuthService {

    @Autowired
    private UserAccountRepo userAccountRepo;

    @Autowired
    private EmployeeRep employeeRep;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtHelper jwtHelper;

    public void signup (SignupRequest signupRequest) {

        Employee employee = employeeRep.findById(signupRequest.EmployeeId())
                .orElseThrow(() -> CustomResponseException.ResourceNotFound("Employee not found !"));

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(signupRequest.username());
        userAccount.setPassowrd(passwordEncoder.encode(signupRequest.password()));
        userAccount.setEmployee(employee);

        userAccountRepo.save(userAccount);
    }

    public String login (LoginRequest loginRequest) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.username(),
                        loginRequest.password()
                )
        );

        UserAccount user = userAccountRepo.findOneByUsername(loginRequest.username())
                .orElseThrow( () -> CustomResponseException.BadCredentials());

        return jwtHelper.generateToken(user);




    }

}
