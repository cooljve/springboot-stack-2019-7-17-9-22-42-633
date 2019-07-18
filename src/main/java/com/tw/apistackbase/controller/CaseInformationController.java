package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.CaseInformation;
import com.tw.apistackbase.model.CriminalCase;
import com.tw.apistackbase.repository.CaseInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CaseInformationController {
  @Autowired
  private CaseInformationRepository repository;

  public CaseInformation findCaseById(int caseId) {
    Optional<CaseInformation> caseInformation = repository.findById(caseId);
    return caseInformation.orElse(null);
  }
}
