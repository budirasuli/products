package com.modena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modena.model.Segmen;

public interface SegmenRepository extends JpaRepository<Segmen, Long> {
    List<Segmen> findByActive(Integer active);
    List<Segmen> findByNameContaining(String name);
    List<Segmen> findBySort(Integer sort); 
}