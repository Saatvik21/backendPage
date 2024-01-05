package com.backend.backendPage.repo;

import com.backend.backendPage.model.SellerRegistration;
import com.backend.backendPage.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRegistrationRepository extends JpaRepository<SellerRegistration, Long> {
    SellerRegistration findByEmail(String email);
}
