package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    // Custom query methods can be added here
}
