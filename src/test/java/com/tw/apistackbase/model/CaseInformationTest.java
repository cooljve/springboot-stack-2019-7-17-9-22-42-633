package com.tw.apistackbase.model;

import com.tw.apistackbase.repository.CaseInformationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class CaseInformationTest {

  @Autowired
  private CaseInformationRepository caseInformationRepository;

  @Test
  void should_add_caseInformation(){
    CaseInformation information = new CaseInformation();
    information.setObjective("aaa");
    information.setSubjectivity("AAA");

    CaseInformation caseInformation = caseInformationRepository.save(information);

    assertThat(caseInformation.getObjective()).isEqualTo("aaa");
  }

  @Test
  void should_find_case_by_id(){
    CaseInformation information = new CaseInformation();
    information.setObjective("aaa");
    information.setSubjectivity("AAA");
    caseInformationRepository.save(information);

    Optional<CaseInformation> caseInformation = caseInformationRepository.findById(information.getId());

    assertThat(caseInformation.get().getObjective()).isEqualTo("aaa");
  }

}