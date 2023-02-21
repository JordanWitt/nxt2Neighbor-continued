package com.example.nxt2neighbor.repositories;

import com.example.nxt2neighbor.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
