package com.digitalhouse.rentcar.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;

   @Column(length = 255, nullable = false)
   private String qualification;

   @Column(length = 255, nullable = false)
   private String description;

   @Column(length = 255, nullable = false)
   private String imageUrl;

   @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JsonIgnore
   private Set<Product> products = new HashSet<>();

}
