package com.backend.backendPage.controller;

import com.backend.backendPage.model.UserRegistration;
import com.backend.backendPage.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
 public class UserRegistrationController {
    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping("/register")
    public UserRegistration registerUser(@RequestBody UserRegistration userRegistration) {
        return userRegistrationService.register(userRegistration);
    }
}
