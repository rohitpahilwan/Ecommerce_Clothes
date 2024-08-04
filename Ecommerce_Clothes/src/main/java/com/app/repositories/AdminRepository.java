package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Custom query methods can be added here
}
