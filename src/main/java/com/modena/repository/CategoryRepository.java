package com.modena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modena.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByActive(Integer active);
    List<Category> findByNameContaining(String name);
}