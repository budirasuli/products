package com.modena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modena.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByActive(Integer active);
    List<Product> findByNameContaining(String name);
}