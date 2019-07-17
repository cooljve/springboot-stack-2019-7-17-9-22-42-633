package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Procurator;
import com.tw.apistackbase.repository.ProcuatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "procurators")
public class ProcuratorController {
  @Autowired
  private ProcuatorRepository repository;

  @GetMapping("{procuratorId}")
  public Procurator findProcuratorById(@PathVariable int procuratorId) {
    Optional<Procurator> procurator = repository.findById(procuratorId);
    return procurator.orElse(null);
  }
}
