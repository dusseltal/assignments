package com.cs.assignment.controller;

import com.cs.assignment.exception.ResourceNotFoundException;
import com.cs.assignment.model.Smoothie;
import com.cs.assignment.repository.SmoothieDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class SmoothieController {
  @Autowired private SmoothieDataRepository smoothieDataRepository;

  @GetMapping("/smoothies")
  public List<Smoothie> getAllSmoothies() {
    return (List<Smoothie>) smoothieDataRepository.findAll();
  }

  @GetMapping("/smoothies/{id}")
  public ResponseEntity<Smoothie> getSmoothieById(@PathVariable(value = "id") Long smoothieId)
      throws ResourceNotFoundException {
    Smoothie smoothie =
        smoothieDataRepository
            .findById(smoothieId)
            .orElseThrow(
                () ->
                    new ResourceNotFoundException(
                        "Smoothie not found for this id :: " + smoothieId));
    return ResponseEntity.ok().body(smoothie);
  }

  @PostMapping("/smoothies")
  public Smoothie createSmoothie(@Valid @RequestBody Smoothie smoothie) {
    return smoothieDataRepository.save(smoothie);
  }

  @PutMapping("/smoothies/{id}")
  public ResponseEntity<Smoothie> updateEmployee(
      @PathVariable(value = "id") Long smoothieId, @Valid @RequestBody Smoothie smoothieDetails)
      throws ResourceNotFoundException {
    Smoothie smoothie =
        smoothieDataRepository
            .findById(smoothieId)
            .orElseThrow(
                () ->
                    new ResourceNotFoundException(
                        "Smoothie not found for this id :: " + smoothieId));

    smoothie.setName(smoothieDetails.getName());
    smoothie.setVitaminA(smoothieDetails.getVitaminA());
    smoothie.setVitaminB(smoothieDetails.getVitaminB());
    smoothie.setVitaminC(smoothieDetails.getVitaminC());
    smoothie.setCalcium(smoothieDetails.getCalcium());
    smoothie.setIron(smoothieDetails.getIron());
    smoothie.setProtein(smoothieDetails.getProtein());
    smoothie.setCarbohydrates(smoothieDetails.getCarbohydrates());
    smoothie.setCholesterol(smoothieDetails.getCholesterol());
    smoothie.setFat(smoothieDetails.getFat());

    Smoothie updatedSmoothie = smoothieDataRepository.save(smoothie);
    return ResponseEntity.ok(updatedSmoothie);
  }

  @DeleteMapping("/smoothies/{id}")
  public Map<String, Boolean> deleteSmoothie(@PathVariable(value = "id") Long smoothieId)
      throws ResourceNotFoundException {
    Smoothie smoothie =
        smoothieDataRepository
            .findById(smoothieId)
            .orElseThrow(
                () ->
                    new ResourceNotFoundException(
                        "Smoothie not found for this id :: " + smoothieId));

    smoothieDataRepository.delete(smoothie);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
