package com.backend.backendPage.service;


import com.backend.backendPage.model.CartItems;
import com.backend.backendPage.repo.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService
{
    @Autowired
    private CartRepository cartRepository;
    public CartItems addCart(CartItems cartItems)
    {
        return cartRepository.save(cartItems);
    }

    public Optional<CartItems> getcart(long id) {
        return cartRepository.findById(id);
    }


    public List<CartItems> getAllcart() {
        return cartRepository.findAll();
    }
}
