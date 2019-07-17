package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Procuracy;
import com.tw.apistackbase.repository.ProcuracyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProcuracyController {

  @Autowired
  private ProcuracyRepository repository;

  public Procuracy findByProcuracyId(int procuracyId) {
    Optional<Procuracy> procuracy = repository.findById(procuracyId);
    return procuracy.orElse(null);
  }
}
