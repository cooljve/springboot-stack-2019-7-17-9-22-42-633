package com.tw.apistackbase.model;

import com.tw.apistackbase.repository.CaseInformationRepository;
import com.tw.apistackbase.repository.CriminalCaseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.Assert.assertNotNull;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class CriminalCaseTest {

  @Autowired
  private CriminalCaseRepository criminalCaseRepository;

  @Autowired
  private CaseInformationRepository informationRepository;

  @Test
  void should_save_criminal_case(){
    CriminalCase criminalCase = new CriminalCase();
    criminalCase.setCaseName("qq");
    criminalCase.setOccurredTime(new Date().getTime());

    CriminalCase fetchedCase = criminalCaseRepository.save(criminalCase);

    assertThat(fetchedCase).isEqualTo(criminalCase);
  }

  @Test
  void should_add_criminal_information_when_add_criminal_case(){
    CaseInformation information = new CaseInformation();
    information.setObjective("abc");
    CriminalCase criminalCase = new CriminalCase();
    criminalCase.setCaseName("qq");
    criminalCase.setOccurredTime(new Date().getTime());
    criminalCase.setCaseInformation(information);
    criminalCaseRepository.save(criminalCase);

    Optional<CaseInformation> fetchedInformation = informationRepository.findById(information.getId());

    assertThat(fetchedInformation.orElse(null).getObjective()).isEqualTo("abc");
  }

  @Test
  void should_find_criminalCase_by_id() {
    Procuracy procuracy = expectProcuracy();
    CriminalCase criminalCase1 = expectCriminalCaseByName("qq",procuracy);
    CriminalCase criminalCase2 = expectCriminalCaseByName("ee",procuracy);
    criminalCaseRepository.save(criminalCase1);
    criminalCaseRepository.save(criminalCase2);

    Optional<CriminalCase> fetchedCase = criminalCaseRepository.findById(criminalCase1.getId());

    assertThat(fetchedCase.orElse(null).getCaseName()).isEqualTo(criminalCase1.getCaseName());
  }

  @Test
  void should_find_criminalCase_by_caseName() {
    Procuracy procuracy = expectProcuracy();
    CriminalCase criminalCase1 = expectCriminalCaseByName("qq",procuracy);
    CriminalCase criminalCase2 = expectCriminalCaseByName("qq",procuracy);
    criminalCaseRepository.save(criminalCase1);
    criminalCaseRepository.save(criminalCase2);

    List<CriminalCase> fetchedCases = criminalCaseRepository.findByCaseName(criminalCase1.getCaseName());

    assertThat(fetchedCases.size()).isEqualTo(2);
    assertThat(fetchedCases.get(0)).isEqualTo(criminalCase1);
    assertThat(fetchedCases.get(1)).isEqualTo(criminalCase2);
  }

  @Test
  void should_find_all_cases_order_by_occurredTime() {
    Procuracy procuracy = expectProcuracy();
    CriminalCase criminalCase1 = expectCriminalCaseByName("qq",procuracy);
    CriminalCase criminalCase2 = expectCriminalCaseByName("ee",procuracy);
    criminalCase2.setOccurredTime(new Date().getTime()-10);
    criminalCaseRepository.save(criminalCase1);
    criminalCaseRepository.save(criminalCase2);

    List<CriminalCase> criminalCases = criminalCaseRepository.findAllByOrderByOccurredTime();

    assertThat(criminalCases.size()).isEqualTo(2);
    assertThat(criminalCases.get(0)).isEqualTo(criminalCase2);
    assertThat(criminalCases.get(1)).isEqualTo(criminalCase1);
  }

  @Test
  void should_delete_case_by_caseId() {
    Procuracy procuracy = expectProcuracy();
    CriminalCase criminalCase1 = expectCriminalCaseByName("qq",procuracy);
    CriminalCase criminalCase2 = expectCriminalCaseByName("ee",procuracy);
    criminalCaseRepository.save(criminalCase1);
    criminalCaseRepository.save(criminalCase2);

    criminalCaseRepository.deleteById(criminalCase1.getId());
    List<CriminalCase> criminalCases = criminalCaseRepository.findAll();

    assertThat(criminalCases.size()).isEqualTo(1);
    assertThat(criminalCases.get(0).getCaseName()).isEqualTo("ee");
  }

  private Procuracy expectProcuracy() {
    Procuracy procuracy = new Procuracy();
    procuracy.setProcuracyName("Q");
    return procuracy;
  }

  CriminalCase expectCriminalCaseByName(String caseName,Procuracy procuracy) {
    CriminalCase criminalCase = new CriminalCase();
    criminalCase.setCaseName(caseName);
    criminalCase.setProcuracy(procuracy);
    criminalCase.setOccurredTime(new Date().getTime());
    return criminalCase;
  }

}