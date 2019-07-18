package com.tw.apistackbase.model;

import com.tw.apistackbase.repository.CriminalCaseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class CriminalCaseTest {

  @Autowired
  private CriminalCaseRepository repository;

  @Test
  void should_save_criminal_case() throws Exception {
    CriminalCase criminalCase = new CriminalCase();
    criminalCase.setCaseName("qq");
    criminalCase.setOccurredTime(new Date().getTime());

    CriminalCase fetchedCase = repository.save(criminalCase);

    assertThat(fetchedCase).isEqualTo(criminalCase);
  }

  @Test
  void should_find_criminalCase_by_id()throws Exception {
    CriminalCase criminalCase = new CriminalCase();
    criminalCase.setCaseName("qq");
    criminalCase.setOccurredTime(new Date().getTime());
    repository.save(criminalCase);

    Optional<CriminalCase> fetchedCase = repository.findById(criminalCase.getId());

    assertThat(fetchedCase.orElse(null).getCaseName()).isEqualTo(criminalCase.getCaseName());
  }


}