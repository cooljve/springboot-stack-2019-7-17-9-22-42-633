package com.tw.apistackbase.model;

import com.tw.apistackbase.repository.ProcuracyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class ProcuracyTest {

  @Autowired
  private ProcuracyRepository procuracyRepository;

  @Test
  void should_find_by_procuracy_id(){
    Procuracy procuracy = new Procuracy();
    procuracy.setProcuracyName("aaa");
    procuracyRepository.save(procuracy);

    Optional<Procuracy> fetchedProcuracy = procuracyRepository.findById(procuracy.getId());

    assertThat(fetchedProcuracy.get().getProcuracyName()).isEqualTo("aaa");
  }

}