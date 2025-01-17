package com.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dto.CartItemDTO;
import com.app.service.CartItemService;

import java.util.List;

@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping
    public ResponseEntity<CartItemDTO> createCartItem(@RequestBody CartItemDTO cartItemDTO) {
        CartItemDTO createdCartItem = cartItemService.createCartItem(cartItemDTO);
        return ResponseEntity.ok(createdCartItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItemDTO> getCartItemById(@PathVariable Long id) {
        CartItemDTO cartItemDTO = cartItemService.getCartItemById(id);
        return ResponseEntity.ok(cartItemDTO);
    }

    @GetMapping
    public ResponseEntity<List<CartItemDTO>> getAllCartItems() {
        List<CartItemDTO> cartItems = cartItemService.getAllCartItems();
        return ResponseEntity.ok(cartItems);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartItemDTO> updateCartItem(@PathVariable Long id, @RequestBody CartItemDTO cartItemDTO) {
        CartItemDTO updatedCartItem = cartItemService.updateCartItem(id, cartItemDTO);
        return ResponseEntity.ok(updatedCartItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        cartItemService.deleteCartItem(id);
        return ResponseEntity.noContent().build();
    }
}

