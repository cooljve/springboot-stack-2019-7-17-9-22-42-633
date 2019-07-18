package com.tw.apistackbase.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Procuracy {
  @Id
  @GeneratedValue
  @Column(unique = true)
  private Integer id;

  @Column(nullable = false,length = 50)
  private String procuracyName;

  @OneToMany
  @JoinColumn(name = "procurator_id")
  private List<Procurator> procurators;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProcuracyName() {
    return procuracyName;
  }

  public void setProcuracyName(String procuracyName) {
    this.procuracyName = procuracyName;
  }

  public List<Procurator> getProcurators() {
    return procurators;
  }

  public void setProcurators(List<Procurator> procurators) {
    this.procurators = procurators;
  }
}
