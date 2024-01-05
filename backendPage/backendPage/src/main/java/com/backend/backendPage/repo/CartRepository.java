package com.backend.backendPage.repo;


import com.backend.backendPage.model.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<CartItems, Long> {

    @Override
    Optional<CartItems> findById(Long id);
}
