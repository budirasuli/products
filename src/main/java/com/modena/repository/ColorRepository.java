package com.modena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modena.model.Color;

public interface ColorRepository extends JpaRepository<Color, Long> {
    List<Color> findByActive(Integer active);
    List<Color> findByNameContaining(String name);
    List<Color> findBySequence(Integer sequence);    
}