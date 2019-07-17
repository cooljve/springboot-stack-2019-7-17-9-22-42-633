package com.tw.apistackbase.model;

import javax.persistence.*;

@Entity
@Table(name = "criminal_case")
public class CriminalCase {
  @Id
  @GeneratedValue
  private int id;

  @Column(nullable = false)
  private String caseName;

  @Column(nullable = false)
  private long occurredTime;

  @OneToOne(cascade = CascadeType.ALL)
  private CaseInformation caseInformation;

  @ManyToOne(optional = false)
  @JoinColumn(name = "procuracy_id")
  private Procuracy procuracy;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCaseName() {
    return caseName;
  }

  public void setCaseName(String caseName) {
    this.caseName = caseName;
  }

  public void setOccurredTime(long occurredTime) {
    this.occurredTime = occurredTime;
  }

  public long getOccurredTime() {
    return occurredTime;
  }

  public CaseInformation getCaseInformation() {
    return caseInformation;
  }

  public void setCaseInformation(CaseInformation caseInformation) {
    this.caseInformation = caseInformation;
  }
}
