package com.example.nxt2neighbor.repositories;

import com.example.nxt2neighbor.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
}
