package com.modena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modena.model.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    List<SubCategory> findByActive(Integer active);
    List<SubCategory> findByNameContaining(String name);
    List<SubCategory> findByPosition(Integer position); 
}