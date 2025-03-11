package com.embarkx.FirstJobApp.Job;

import com.embarkx.FirstJobApp.Company.Company;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Job {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;
  private String title;
  private String description;
  private String minSalary;
  private String maxSalary;
  private String location;

  @ManyToOne
  private Company company;

}
