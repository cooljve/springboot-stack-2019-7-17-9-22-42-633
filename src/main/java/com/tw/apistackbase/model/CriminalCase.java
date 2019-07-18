package com.tw.apistackbase.model;

import javax.persistence.*;

@Entity
@Table(name = "criminal_case")
public class CriminalCase {
  @Id
  @GeneratedValue
  private Integer id;

  @Column(nullable = false)
  private String caseName;

  @Column(nullable = false)
  private Long occurredTime;

  @OneToOne(cascade = CascadeType.ALL)
  private CaseInformation caseInformation;

  @ManyToOne(optional = false,cascade = CascadeType.ALL)
  @JoinColumn(name = "procuracy_id")
  private Procuracy procuracy;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCaseName() {
    return caseName;
  }

  public void setCaseName(String caseName) {
    this.caseName = caseName;
  }

  public Long getOccurredTime() {
    return occurredTime;
  }

  public void setOccurredTime(Long occurredTime) {
    this.occurredTime = occurredTime;
  }

  public CaseInformation getCaseInformation() {
    return caseInformation;
  }

  public void setCaseInformation(CaseInformation caseInformation) {
    this.caseInformation = caseInformation;
  }

  public Procuracy getProcuracy() {
    return procuracy;
  }

  public void setProcuracy(Procuracy procuracy) {
    this.procuracy = procuracy;
  }
}
