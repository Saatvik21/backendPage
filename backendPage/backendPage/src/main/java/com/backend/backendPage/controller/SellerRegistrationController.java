package com.backend.backendPage.controller;

import com.backend.backendPage.model.SellerRegistration;
import com.backend.backendPage.service.SellerRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class SellerRegistrationController {
    @Autowired
    private SellerRegistrationService sellerRegistrationService;
    @PostMapping("/sellerregister")
    public SellerRegistration registerSeller(@RequestBody SellerRegistration sellerRegistration) {
        return sellerRegistrationService.registers(sellerRegistration);
    }
}
