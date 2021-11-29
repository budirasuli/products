package com.modena.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.modena.model.Segmen;
import com.modena.repository.SegmenRepository;

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
public class SegmenController {

  @Autowired
  SegmenRepository segmenRepository;

  @GetMapping("/segments")
  public ResponseEntity<List<Segmen>> getAllSegments(@RequestParam(required = false) String name) {
    try {
      List<Segmen> segmens = new ArrayList<Segmen>();

      if (name == null)
        segmenRepository.findAll().forEach(segmens::add);
      else
        segmenRepository.findByNameContaining(name).forEach(segmens::add);

      if (segmens.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(segmens, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/segments/{id}")
  public ResponseEntity<Segmen> getSegmenById(@PathVariable("id") long id) {
    Optional<Segmen> segmenData = segmenRepository.findById(id);

    if (segmenData.isPresent()) {
      return new ResponseEntity<>(segmenData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/segments")
  public ResponseEntity<Segmen> createSegmen(@RequestBody Segmen segmen) {
    try {
      Segmen _segmen = segmenRepository
      .save(new Segmen(segmen.getName(), segmen.getActive(), segmen.getPosition()));
      return new ResponseEntity<>(_segmen, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/segments/{id}")
  public ResponseEntity<Segmen> updateSegmen(@PathVariable("id") long id, @RequestBody Segmen segmen) {
    Optional<Segmen> segmenData = segmenRepository.findById(id);

    if (segmenData.isPresent()) {
      Segmen _segmen = segmenData.get();
      _segmen.setName(segmen.getName());
      _segmen.setActive(segmen.getActive());
      _segmen.setPosition(segmen.getPosition());
      return new ResponseEntity<>(segmenRepository.save(_segmen), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/segments/{id}")
  public ResponseEntity<HttpStatus> deleteSegmen(@PathVariable("id") long id) {
    try {
      segmenRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
