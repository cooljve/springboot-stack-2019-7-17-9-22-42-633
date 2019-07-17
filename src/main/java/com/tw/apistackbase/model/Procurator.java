package com.tw.apistackbase.model;

import javax.persistence.*;

@Entity
@Table
public class Procurator {
  @Id
  @GeneratedValue
  private Integer id;

  @Column(nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name ="procuracy_id")
  private Procuracy procuracy;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Procuracy getProcuracy() {
    return procuracy;
  }

  public void setProcuracy(Procuracy procuracy) {
    this.procuracy = procuracy;
  }
}
