package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.CriminalCase;
import com.tw.apistackbase.repository.CriminalCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CriminalCaseController {

  @Autowired
  private CriminalCaseRepository repository;

  public CriminalCase findCriminalCaseById(int ceiminalId) {
    Optional<CriminalCase> criminalCase = repository.findById(ceiminalId);
    return criminalCase.orElse(null);
  }

  public List<CriminalCase> findAllCriminalCases() {
    return repository.findAll();
  }

  public List<CriminalCase> findCriminalCasesByCriminalName(String name) {
    return repository.findByCriminalName(name);
  }

  public void deleteByCriminalId(int criminalId) {
    repository.deleteById(criminalId);
  }


}
