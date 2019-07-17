package com.tw.apistackbase.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Procuracy {
  @Id
  @GeneratedValue
  @Column(unique = true)
  private int id;

  @Column(nullable = false,length = 50)
  private String procuracyName;

  @OneToMany(mappedBy = "procuracy")
  private List<CriminalCase> criminalCases;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProcuracyName() {
    return procuracyName;
  }

  public void setProcuracyName(String procuracyName) {
    this.procuracyName = procuracyName;
  }

  public List<CriminalCase> getCriminalCases() {
    return criminalCases;
  }

  public void setCriminalCases(List<CriminalCase> criminalCases) {
    this.criminalCases = criminalCases;
  }
}
