package com.modena.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.modena.model.Color;
import com.modena.repository.ColorRepository;

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
public class ColorController {

  @Autowired
  ColorRepository colorRepository;

  @GetMapping("/color")
  public ResponseEntity<List<Color>> getAllColors(@RequestParam(required = false) String name) {
    try {
      List<Color> color = new ArrayList<Color>();

      if (name == null)
        colorRepository.findAll().forEach(color::add);
      else
        colorRepository.findByNameContaining(name).forEach(color::add);

      if (color.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(color, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/color/{id}")
  public ResponseEntity<Color> getColorById(@PathVariable("id") long id) {
    Optional<Color> colorData = colorRepository.findById(id);

    if (colorData.isPresent()) {
      return new ResponseEntity<>(colorData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/color")
  public ResponseEntity<Color> createColors(@RequestBody Color color) {
    try {
      Color _color = colorRepository
      .save(new Color(color.getId_product_color_id(), color.getName(), color.getActive(), color.getSort(), color.getLanguage_code(), color.getCountry_code()));
      return new ResponseEntity<>(_color, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/color/{id}")
  public ResponseEntity<Color> updateColors(@PathVariable("id") long id, @RequestBody Color color) {
    Optional<Color> colorData = colorRepository.findById(id);

    if (colorData.isPresent()) {
      Color _color = colorData.get();
      _color.setId_product_color_id(color.getId_product_color_id());
      _color.setName(color.getName());
      _color.setActive(color.getActive());
      _color.setSort(color.getSort());
      _color.setCountry_code(color.getCountry_code());
      _color.setLanguage_code(color.getLanguage_code());
      return new ResponseEntity<>(colorRepository.save(_color), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/color/{id}")
  public ResponseEntity<HttpStatus> deleteColor(@PathVariable("id") long id) {
    try {
      colorRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
