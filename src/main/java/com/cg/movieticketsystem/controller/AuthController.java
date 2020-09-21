package com.cg.movieticketsystem.controller;

import com.cg.movieticketsystem.Service.AuthService;
import com.cg.movieticketsystem.dto.request.LoginRequest;
import com.cg.movieticketsystem.dto.request.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authService.authenticateUser(request));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authService.registerUser(request));
    }

}
