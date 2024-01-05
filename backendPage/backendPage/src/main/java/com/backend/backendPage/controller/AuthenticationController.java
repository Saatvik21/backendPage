package com.backend.backendPage.controller;

import com.backend.backendPage.model.SellerRegistration;
import com.backend.backendPage.model.UserRegistration;
import com.backend.backendPage.service.SellerRegistrationService;
import com.backend.backendPage.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private UserRegistrationService userRegistrationServiceService;

    @Autowired
    private SellerRegistrationService sellerRegistrationService;
    @PostMapping("/register")
    public ResponseEntity<UserRegistration> registerUser(@RequestBody UserRegistration userRegistration) {
        UserRegistration registeredUser = userRegistrationServiceService.register(userRegistration);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/sellerregister")
    public ResponseEntity<SellerRegistration> registerSeller(@RequestBody SellerRegistration sellerRegistration) {
        SellerRegistration registeredSeller = sellerRegistrationService.registers(sellerRegistration);
        return ResponseEntity.ok(registeredSeller);
    }
    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String createPassword = credentials.get("createPassword");
        System.out.println("AuthController " + email + " " + createPassword);

        UserRegistration loggedInUser = userRegistrationServiceService.loginUser(email, createPassword);

        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }

    }

    @PostMapping("/seller-login")
    public ResponseEntity<Object> loginSeller(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String createPassword = credentials.get("createPassword");
        System.out.println("AuthController " + email + " " + createPassword);

        SellerRegistration loggedInSeller = sellerRegistrationService.loginSeller(email, createPassword);

        if (loggedInSeller != null) {
            return ResponseEntity.ok(loggedInSeller);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }


}
