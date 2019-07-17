package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Procuracy;
import com.tw.apistackbase.repository.ProcuracyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "procuracies")
public class ProcuracyController {

  @Autowired
  private ProcuracyRepository repository;

  @GetMapping(value = "{procuracyId}")
  public Procuracy findByProcuracyId(@PathVariable int procuracyId) {
    Optional<Procuracy> procuracy = repository.findById(procuracyId);
    return procuracy.orElse(null);
  }
}
