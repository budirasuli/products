package com.modena.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.modena.model.Subcategory;
import com.modena.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class SubcategoryController {

  @Autowired
  SubcategoryRepository subcategoryRepository;

  @GetMapping("/subcategory")
  public ResponseEntity<List<Subcategory>> getAllSubcategories(@RequestParam(required = false) String name) {
    try {
      List<Subcategory> subcategories = new ArrayList<Subcategory>();

      if (name == null)
        subcategoryRepository.findAll().forEach(subcategories::add);
      else
        subcategoryRepository.findByNameContaining(name).forEach(subcategories::add);

      if (subcategories.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(subcategories, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/subcategory/{id}")
  public ResponseEntity<Subcategory> getSubcategoryById(@PathVariable("id") long id) {
    Optional<Subcategory> subcategoryData = subcategoryRepository.findById(id);

    if (subcategoryData.isPresent()) {
      return new ResponseEntity<>(subcategoryData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/subcategory")
  public ResponseEntity<Subcategory> createSubcategorys(@RequestBody Subcategory subcategory) {
    try {
      Subcategory _subcategory = subcategoryRepository
      .save(new Subcategory(subcategory.getId_product_sub_category_id(), subcategory.getId_product_category_id(), subcategory.getId_product_segment_id(), subcategory.getName(), subcategory.getActive(), subcategory.getCountry_code(), subcategory.getLanguage_code(), subcategory.getIs_tradein(), subcategory.getIs_rental()));
      return new ResponseEntity<>(_subcategory, HttpStatus.CREATED);
      } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/subcategory/{id}")
  public ResponseEntity<Subcategory> updateSubcategorys(@PathVariable("id") long id, @RequestBody Subcategory subcategory) {
    Optional<Subcategory> subcategoryData = subcategoryRepository.findById(id);

    if (subcategoryData.isPresent()) {
      Subcategory _subcategory = subcategoryData.get();
      _subcategory.setId_product_sub_category_id(subcategory.getId_product_sub_category_id());
      _subcategory.setId_product_category_id(subcategory.getId_product_category_id());
      _subcategory.setId_product_segment_id(subcategory.getId_product_segment_id());
      _subcategory.setName(subcategory.getName());
      _subcategory.setActive(subcategory.getActive());
      _subcategory.setCountry_code(subcategory.getCountry_code());
      _subcategory.setLanguage_code(subcategory.getLanguage_code());
      return new ResponseEntity<>(subcategoryRepository.save(_subcategory), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/subcategory/{id}")
  public ResponseEntity<HttpStatus> deleteSubcategorys(@PathVariable("id") long id) {
    try {
      subcategoryRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
