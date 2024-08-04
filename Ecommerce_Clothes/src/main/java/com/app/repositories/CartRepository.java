package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    // Custom query methods can be added here
}
