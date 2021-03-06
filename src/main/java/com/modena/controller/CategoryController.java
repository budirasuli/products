package com.modena.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.modena.model.Category;
import com.modena.repository.CategoryRepository;
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
public class CategoryController {

  @Autowired
  CategoryRepository categoryRepository;

  @GetMapping("/category")
  public ResponseEntity<List<Category>> getAllCategories(@RequestParam(required = false) String name) {
    try {
      List<Category> categories = new ArrayList<Category>();

      if (name == null)
        categoryRepository.findAll().forEach(categories::add);
      else
        categoryRepository.findByNameContaining(name).forEach(categories::add);

      if (categories.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(categories, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/category/{id}")
  public ResponseEntity<Category> getCategoryById(@PathVariable("id") long id) {
    Optional<Category> categoryData = categoryRepository.findById(id);

    if (categoryData.isPresent()) {
      return new ResponseEntity<>(categoryData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/category")
  public ResponseEntity<Category> createCategorys(@RequestBody Category category) {
    try {
      Category _category = categoryRepository
      .save(new Category(category.getId_product_category_id(), category.getId_product_segment_id(), category.getName(), category.getActive(), category.getLanguage_code(), category.getCountry_code(), category.getSort()));
      return new ResponseEntity<>(_category, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/category/{id}")
  public ResponseEntity<Category> updateCategorys(@PathVariable("id") long id, @RequestBody Category category) {
    Optional<Category> categoryData = categoryRepository.findById(id);

    if (categoryData.isPresent()) {
      Category _category = categoryData.get();
      _category.setId_product_category_id(category.getId_product_category_id());
      _category.setId_product_segment_id(category.getId_product_segment_id());
      _category.setName(category.getName());
      _category.setActive(category.getActive());
      _category.setCountry_code(category.getCountry_code());
      _category.setLanguage_code(category.getLanguage_code());
      _category.setSort(category.getSort());
      
      return new ResponseEntity<>(categoryRepository.save(_category), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/category/{id}")
  public ResponseEntity<HttpStatus> deleteCategorys(@PathVariable("id") long id) {
    try {
      categoryRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
