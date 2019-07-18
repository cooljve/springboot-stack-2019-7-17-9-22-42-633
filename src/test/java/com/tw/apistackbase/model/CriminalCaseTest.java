package com.tw.apistackbase.model;

import com.tw.apistackbase.repository.CriminalCaseRepository;
import com.tw.apistackbase.repository.ProcuracyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class CriminalCaseTest {

  @Autowired
  private CriminalCaseRepository criminalCaseRepository;
  @Autowired
  private ProcuracyRepository procuracyRepository;

  @Test
  void should_save_criminal_case() throws Exception {
    CriminalCase criminalCase = new CriminalCase();
    criminalCase.setCaseName("qq");
    criminalCase.setOccurredTime(new Date().getTime());

    CriminalCase fetchedCase = criminalCaseRepository.save(criminalCase);

    assertThat(fetchedCase).isEqualTo(criminalCase);
  }

  @Test
  void should_find_criminalCase_by_id() throws Exception {
    CriminalCase criminalCase1 = new CriminalCase();
    criminalCase1.setCaseName("qq");
    criminalCase1.setOccurredTime(new Date().getTime());
    CriminalCase criminalCase2 = new CriminalCase();
    criminalCase2.setCaseName("ee");
    criminalCase2.setOccurredTime(new Date().getTime());
    criminalCaseRepository.save(criminalCase1);
    criminalCaseRepository.save(criminalCase2);

    Optional<CriminalCase> fetchedCase = criminalCaseRepository.findById(criminalCase1.getId());

    assertThat(fetchedCase.orElse(null).getCaseName()).isEqualTo(criminalCase1.getCaseName());
  }

  @Test
  void should_find_criminalCase_by_caseName() throws Exception {
    Procuracy procuracy1 = new Procuracy();
    procuracy1.setProcuracyName("Q");
    Procuracy procuracy2 = new Procuracy();
    procuracy2.setProcuracyName("E");
    procuracyRepository.save(procuracy1);
    procuracyRepository.save(procuracy2);
    CriminalCase criminalCase1 = new CriminalCase();
    criminalCase1.setCaseName("qq");
    criminalCase1.setOccurredTime(new Date().getTime());
    criminalCase1.setProcuracy(procuracy1);
    CriminalCase criminalCase2 = new CriminalCase();
    criminalCase2.setCaseName("qq");
    criminalCase2.setOccurredTime(new Date().getTime());
    criminalCase2.setProcuracy(new Procuracy());
    criminalCase2.setProcuracy(procuracy2);
    criminalCaseRepository.save(criminalCase1);
    criminalCaseRepository.save(criminalCase2);

    List<CriminalCase> fetchedCases = criminalCaseRepository.findByCaseName(criminalCase1.getCaseName());

    assertThat(fetchedCases.size()).isEqualTo(2);
    assertThat(fetchedCases.get(0)).isEqualTo(criminalCase1);
    assertThat(fetchedCases.get(1)).isEqualTo(criminalCase2);
  }

  @Test
  void should_find_all_cases_order_by_occurredTime() {
    Procuracy procuracy1 = new Procuracy();
    procuracy1.setProcuracyName("Q");
    Procuracy procuracy2 = new Procuracy();
    procuracy2.setProcuracyName("E");
    procuracyRepository.save(procuracy1);
    procuracyRepository.save(procuracy2);
    CriminalCase criminalCase1 = new CriminalCase();
    criminalCase1.setCaseName("qq");
    criminalCase1.setOccurredTime(new Date().getTime());
    criminalCase1.setProcuracy(procuracy1);
    CriminalCase criminalCase2 = new CriminalCase();
    criminalCase2.setCaseName("qq");
    criminalCase2.setOccurredTime(new Date().getTime() - 10);
    criminalCase2.setProcuracy(new Procuracy());
    criminalCase2.setProcuracy(procuracy2);
    criminalCaseRepository.save(criminalCase1);
    criminalCaseRepository.save(criminalCase2);

    List<CriminalCase> criminalCases = criminalCaseRepository.findAllByOrderByOccurredTime();

    assertThat(criminalCases.size()).isEqualTo(2);
    assertThat(criminalCases.get(0)).isEqualTo(criminalCase2);
    assertThat(criminalCases.get(1)).isEqualTo(criminalCase1);
  }

  @Test
  void should_delete_case_by_caseId() {
    Procuracy procuracy1 = new Procuracy();
    procuracy1.setProcuracyName("Q");
    Procuracy procuracy2 = new Procuracy();
    procuracy2.setProcuracyName("E");
    procuracyRepository.save(procuracy1);
    procuracyRepository.save(procuracy2);
    CriminalCase criminalCase1 = new CriminalCase();
    criminalCase1.setCaseName("qq");
    criminalCase1.setOccurredTime(new Date().getTime());
    criminalCase1.setProcuracy(procuracy1);
    CriminalCase criminalCase2 = new CriminalCase();
    criminalCase2.setCaseName("ee");
    criminalCase2.setOccurredTime(new Date().getTime() - 10);
    criminalCase2.setProcuracy(new Procuracy());
    criminalCase2.setProcuracy(procuracy2);
    criminalCaseRepository.save(criminalCase1);
    criminalCaseRepository.save(criminalCase2);

    criminalCaseRepository.deleteById(criminalCase1.getId());
    List<CriminalCase> criminalCases = criminalCaseRepository.findAll();

    assertThat(criminalCases.size()).isEqualTo(1);
    assertThat(criminalCases.get(0).getCaseName()).isEqualTo("ee");
  }

}