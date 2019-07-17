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
}
