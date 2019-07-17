package com.tw.apistackbase.model;

import javax.persistence.*;

@Entity
@Table
public class Procuracy {
  @Id
  @GeneratedValue
  @Column(unique = true)
  private int id;

  @Column(nullable = false,length = 50)
  private String procuracyName;

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
}
