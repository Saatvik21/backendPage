package com.backend.backendPage.controller;


import com.backend.backendPage.model.CartItems;
import com.backend.backendPage.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
    @Autowired
    private CartService cartService;
    @GetMapping("/getcart/{id}")
    public Optional<CartItems> getcart(@PathVariable("id") long id)
    {
        return cartService.getcart(id);
    }
    @GetMapping("/getallcart")
    public List<CartItems> getAllcart()
    {
        return cartService.getAllcart();
    }


    @PostMapping("/addcart")
    public CartItems addCart(@RequestBody CartItems cartItems)
    {
        return cartService.addCart(cartItems);
    }

}
