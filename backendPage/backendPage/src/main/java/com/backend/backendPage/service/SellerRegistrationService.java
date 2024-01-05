package com.backend.backendPage.service;

import com.backend.backendPage.model.SellerRegistration;
import com.backend.backendPage.model.UserRegistration;
import com.backend.backendPage.repo.SellerRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerRegistrationService {
    @Autowired
    private SellerRegistrationRepository sellerRegistrationRepository;


    public SellerRegistration registers(SellerRegistration sellerRegistration) {
        return sellerRegistrationRepository.save(sellerRegistration);
    }

    public SellerRegistration loginSeller(String email, String password) {
        SellerRegistration user = sellerRegistrationRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            // User authenticated successfully
            return user;
        } else {
            // Authentication failed
            return null;
        }
    }
}
