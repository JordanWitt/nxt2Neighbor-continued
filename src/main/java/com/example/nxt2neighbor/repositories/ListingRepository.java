package com.example.nxt2neighbor.repositories;

import com.example.nxt2neighbor.models.Listings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listings, Long> {
}
