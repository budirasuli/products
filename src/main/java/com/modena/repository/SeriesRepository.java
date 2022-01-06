package com.modena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modena.model.Series;

public interface SeriesRepository extends JpaRepository<Series, Long> {
    List<Series> findByActive(Integer active);
    List<Series> findByNameContaining(String name);
    List<Series> findBySort(Integer sort);    
}