package com.backend.backendPage.service;

import com.backend.backendPage.model.UserRegistration;
import com.backend.backendPage.repo.UserRegistrationRepository;
 import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;


    public UserRegistration register(UserRegistration userRegistration) {
         return userRegistrationRepository.save(userRegistration);
    }
    public UserRegistration loginUser(String email, String password) {
        UserRegistration user = userRegistrationRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            // User authenticated successfully
            return user;
        } else {
            // Authentication failed
            return null;
        }
    }

//    public UserRegistration register(UserRegistration userRegistration) {
//        // Check if the username is already taken
//        if (userRegistrationRepository.findByEmail(userRegistration.getEmail()).isPresent()) {
//            throw new IllegalArgumentException("Username is already taken.");
//        }
//
//    /*
//    // Encrypt the password before saving it
//    user.setPassword(passwordEncoder.encode(user.getPassword())); */
//
//        return userRegistrationRepository.save(userRegistration);
//    }
//
//    public UserRegistration loginUser(String email, String password) {
//
//        // Find the user by username
//        UserRegistration userRegistration = (UserRegistration) userRegistrationRepository.findByEmail(email)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password."));
//
//    /*
//    // Check if the provided password matches the stored encrypted password
//    if (!passwordEncoder.matches(password, user.getPassword())) {
//        throw new IllegalArgumentException("Invalid username or password.");
//    } */
//
//        return userRegistration;
//    }

}
