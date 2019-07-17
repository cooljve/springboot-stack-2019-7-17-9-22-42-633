package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Procurator;
import com.tw.apistackbase.repository.ProcuatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProcuratorController {
  @Autowired
  private ProcuatorRepository repository;

  public Procurator findProcuratorById(int procuratorId) {
    Optional<Procurator> procurator = repository.findById(procuratorId);
    return procurator.orElse(null);
  }
}
