package com.tw.apistackbase.model;

import javax.persistence.*;

@Entity
@Table
public class CaseInformation {
  @Id
  @GeneratedValue
  private Integer id;

  @Column(nullable = false)
  private String objective;

  @Column(nullable = false)
  private String subjectivity;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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
