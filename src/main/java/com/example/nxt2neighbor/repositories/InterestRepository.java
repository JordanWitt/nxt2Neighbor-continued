package com.example.nxt2neighbor.repositories;

import com.example.nxt2neighbor.models.Interests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepository extends JpaRepository<Interests, Long> {
}
