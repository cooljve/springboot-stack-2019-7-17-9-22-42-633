package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.CriminalCase;
import com.tw.apistackbase.repository.CriminalCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "criminal-cases")
public class CriminalCaseController {

  @Autowired
  private CriminalCaseRepository repository;

  @GetMapping(value = "{criminalId}")
  public CriminalCase findCriminalCaseById(@PathVariable int criminalId) {
    Optional<CriminalCase> criminalCase = repository.findById(criminalId);
    return criminalCase.orElse(null);
  }

  @GetMapping
  public List<CriminalCase> findAllCriminalCases() {
    return repository.findAllByOrderByOccurredTime();
  }

  @GetMapping(value = "{criminalName}")
  public List<CriminalCase> findCriminalCasesByCriminalName(@PathVariable String criminalName) {
    return repository.findByCaseName(criminalName);
  }

  @DeleteMapping(value = "{criminalId}")
  public void deleteByCriminalId(@PathVariable int criminalId) {
    repository.deleteById(criminalId);
  }


}
