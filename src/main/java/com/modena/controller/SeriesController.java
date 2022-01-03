package com.modena.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.modena.model.Series;
import com.modena.repository.SeriesRepository;

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
public class SeriesController {

  @Autowired
  SeriesRepository seriesRepository;

  @GetMapping("/series")
  public ResponseEntity<List<Series>> getAllSeries(@RequestParam(required = false) String name) {
    try {
      List<Series> series = new ArrayList<Series>();

      if (name == null)
        seriesRepository.findAll().forEach(series::add);
      else
        seriesRepository.findByNameContaining(name).forEach(series::add);

      if (series.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(series, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/series/{id}")
  public ResponseEntity<Series> getSeriesById(@PathVariable("id") long id) {
    Optional<Series> seriesData = seriesRepository.findById(id);

    if (seriesData.isPresent()) {
      return new ResponseEntity<>(seriesData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/series")
  public ResponseEntity<Series> createSeries(@RequestBody Series series) {
    try {
      Series _series = seriesRepository
      .save(new Series(series.getName(), series.getActive(), series.getSequence(), series.getLanguage_code(), series.getCountry_code()));
      return new ResponseEntity<>(_series, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/series/{id}")
  public ResponseEntity<Series> updateSeries(@PathVariable("id") long id, @RequestBody Series series) {
    Optional<Series> seriesData = seriesRepository.findById(id);

    if (seriesData.isPresent()) {
      Series _series = seriesData.get();
      _series.setName(series.getName());
      _series.setActive(series.getActive());
      _series.setSequence(series.getSequence());
      _series.setCountry_code(series.getCountry_code());
      _series.setLanguage_code(series.getLanguage_code());
      return new ResponseEntity<>(seriesRepository.save(_series), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/series/{id}")
  public ResponseEntity<HttpStatus> deleteSeries(@PathVariable("id") long id) {
    try {
      seriesRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
