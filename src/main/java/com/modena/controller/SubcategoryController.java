package com.modena.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.modena.model.SubCategory;
import com.modena.repository.SubCategoryRepository;
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
public class SubCategoryController {

  @Autowired
  SubCategoryRepository subcategoryRepository;

  @GetMapping("/subcategory")
  public ResponseEntity<List<SubCategory>> getAllSubCategories(@RequestParam(required = false) String name) {
    try {
      List<SubCategory> subcategories = new ArrayList<SubCategory>();

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
  public ResponseEntity<SubCategory> getSubCategoryById(@PathVariable("id") long id) {
    Optional<SubCategory> subcategoryData = subcategoryRepository.findById(id);

    if (subcategoryData.isPresent()) {
      return new ResponseEntity<>(subcategoryData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/subcategory")
  public ResponseEntity<SubCategory> createsubCategorys(@RequestBody SubCategory subcategory) {
    try {
      SubCategory _subcategory = subcategoryRepository
      .save(new SubCategory(subcategory.getCategory_id(), subcategory.getName(), subcategory.getActive(), subcategory.getPosition(), subcategory.getCountry_code(), subcategory.getLanguage_code(), subcategory.getTradein(), subcategory.getRental()));
      return new ResponseEntity<>(_subcategory, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/subcategory/{id}")
  public ResponseEntity<SubCategory> updateSubCategorys(@PathVariable("id") long id, @RequestBody SubCategory subcategory) {
    Optional<SubCategory> subcategoryData = subcategoryRepository.findById(id);

    if (subcategoryData.isPresent()) {
      SubCategory _subcategory = subcategoryData.get();
      _subcategory.setCategory_id(subcategory.getCategory_id());
      _subcategory.setName(subcategory.getName());
      _subcategory.setActive(subcategory.getActive());
      _subcategory.setPosition(subcategory.getPosition());
      _subcategory.setCountry_code(subcategory.getCountry_code());
      _subcategory.setLanguage_code(subcategory.getLanguage_code());
      _subcategory.setTradein(subcategory.getTradein());
      _subcategory.setRental(subcategory.getRental());
      return new ResponseEntity<>(subcategoryRepository.save(_subcategory), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/subcategory/{id}")
  public ResponseEntity<HttpStatus> deleteSubCategorys(@PathVariable("id") long id) {
    try {
      subcategoryRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
