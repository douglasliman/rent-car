package com.digitalhouse.rentcar.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 1000, nullable = false)
    private String description;


    @Column(length = 255 ,nullable = false)
    private String price;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_feature",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_feature")
    )
    @JsonIgnore
    private Set<Feature> features = new HashSet<>();


    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(length = 10 ,nullable = false)
    private boolean isAvailable;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_images",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_image")
    )
    @JsonIgnore
    private Set<Image> images = new HashSet<>();


}
