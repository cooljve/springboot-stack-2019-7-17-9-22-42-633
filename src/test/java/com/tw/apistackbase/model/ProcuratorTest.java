package com.tw.apistackbase.model;

import com.tw.apistackbase.repository.ProcuatorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ProcuratorTest {

  @Autowired
  private ProcuatorRepository procuatorRepository;

  @Test
  void should_find_by_procuator_id(){
    Procurator procurator = new Procurator();
    procurator.setName("Bob");
    procuatorRepository.save(procurator);

    Optional<Procurator> fetchedProcurator = procuatorRepository.findById(procurator.getId());

    assertThat(fetchedProcurator.get().getName()).isEqualTo("Bob");
  }

}