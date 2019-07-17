package com.tw.apistackbase.model;

import javax.persistence.*;

@Entity
@Table
public class CaseInfomation {
  @Id
  @GeneratedValue
  private int id;

  @Column(nullable = false)
  private String objective;

  @Column(nullable = false)
  private String subjectivity;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getObjective() {
    return objective;
  }

  public void setObjective(String objective) {
    this.objective = objective;
  }

  public String getSubjectivity() {
    return subjectivity;
  }

  public void setSubjectivity(String subjectivity) {
    this.subjectivity = subjectivity;
  }
}
