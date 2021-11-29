package com.modena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modena.model.Subcategory;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    List<Subcategory> findByActive(Integer active);
    List<Subcategory> findByNameContaining(String name);
    List<Subcategory> findByPosition(Integer position);
    List<Subcategory> findByCategoryid(Integer categoryid);
    
}