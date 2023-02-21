package com.example.nxt2neighbor.repositories;

import com.example.nxt2neighbor.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categories, Long> {
}
