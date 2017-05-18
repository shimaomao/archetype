package com.siyu.entity;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Greeting implements Serializable {

  private static final long serialVersionUID = -1;

  @Id
  @GeneratedValue
  private Long id;

  @Length(max = 20, message = "length must less than 20")
  @Column(nullable = false, length = 20, unique = true)
  private String toWhom;

  @Version
  private Long version;
}
