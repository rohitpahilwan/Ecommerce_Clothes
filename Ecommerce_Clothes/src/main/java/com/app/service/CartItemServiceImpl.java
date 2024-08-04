package com.app.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.CartItemDTO;
import com.app.entities.CartItem;
import com.app.repositories.CartItemRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CartItemDTO createCartItem(CartItemDTO cartItemDTO) {
        CartItem cartItem = modelMapper.map(cartItemDTO, CartItem.class);
        CartItem savedCartItem = cartItemRepository.save(cartItem);
        return modelMapper.map(savedCartItem, CartItemDTO.class);
    }

    @Override
    public CartItemDTO getCartItemById(Long id) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CartItem not found"));
        return modelMapper.map(cartItem, CartItemDTO.class);
    }

    @Override
    public List<CartItemDTO> getAllCartItems() {
        List<CartItem> cartItems = cartItemRepository.findAll();
        return cartItems.stream()
                .map(cartItem -> modelMapper.map(cartItem, CartItemDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CartItemDTO updateCartItem(Long id, CartItemDTO cartItemDTO) {
        CartItem cartItem = modelMapper.map(cartItemDTO, CartItem.class);
        cartItem.setId(id);
        CartItem updatedCartItem = cartItemRepository.save(cartItem);
        return modelMapper.map(updatedCartItem, CartItemDTO.class);
    }

    @Override
    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }
}
