package com.app.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.CartDTO;
import com.app.entities.Cart;
import com.app.repositories.CartRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CartDTO createCart(CartDTO cartDTO) {
        Cart cart = modelMapper.map(cartDTO, Cart.class);
        Cart savedCart = cartRepository.save(cart);
        return modelMapper.map(savedCart, CartDTO.class);
    }

    @Override
    public CartDTO getCartById(Long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        return modelMapper.map(cart, CartDTO.class);
    }

    @Override
    public List<CartDTO> getAllCarts() {
        List<Cart> carts = cartRepository.findAll();
        return carts.stream()
                .map(cart -> modelMapper.map(cart, CartDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CartDTO updateCart(Long id, CartDTO cartDTO) {
        Cart cart = modelMapper.map(cartDTO, Cart.class);
        cart.setId(id);
        Cart updatedCart = cartRepository.save(cart);
        return modelMapper.map(updatedCart, CartDTO.class);
    }

    @Override
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
}
