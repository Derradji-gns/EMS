package com.derradjiamine.Backend.controllers;


import com.derradjiamine.Backend.dtos.LoginRequest;
import com.derradjiamine.Backend.dtos.SignupRequest;
import com.derradjiamine.Backend.services.AuthService;
import com.derradjiamine.Backend.shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public String signup(@RequestBody @Valid SignupRequest signupRequest) {

        authService.signup(signupRequest);

        return new ResponseEntity<>(new GlobalResponse<>("signed up"), HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginRequest loginRequest) {

        String token = authService.login(loginRequest);

        return new ResponseEntity<>(new GlobalResponse<>(token), HttpStatus.CREATED);

    }

}
