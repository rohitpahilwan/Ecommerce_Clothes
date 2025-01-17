package com.app.service;


import java.util.List;

import com.app.dto.CartDTO;

public interface CartService {

    CartDTO createCart(CartDTO cartDTO);

    CartDTO getCartById(Long id);

    List<CartDTO> getAllCarts();

    CartDTO updateCart(Long id, CartDTO cartDTO);

    void deleteCart(Long id);
}
