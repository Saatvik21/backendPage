package com.backend.backendPage.repo;

import com.backend.backendPage.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Long> {

//    Optional<Object> findByEmail(String email);
    UserRegistration findByEmail(String email);
}
