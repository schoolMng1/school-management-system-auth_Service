package com.school_mng_auth.controller;

import com.school_mng_auth.dto.LoginRequest;
import com.school_mng_auth.dto.RegisterRequest;
import com.school_mng_auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    private UserService userService;

    @Autowired
    AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<String> createUser(@RequestBody RegisterRequest registerRequest) {
        String result = userService.register(registerRequest);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {

       String result =  userService.login(loginRequest);
        return  ResponseEntity.ok().body(result);
    }
}