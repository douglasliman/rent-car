package com.digitalhouse.rentcar.app.api.dto.response.product;

import com.digitalhouse.rentcar.domain.entity.Category;
import com.digitalhouse.rentcar.domain.entity.City;
import com.digitalhouse.rentcar.domain.entity.Feature;
import com.digitalhouse.rentcar.domain.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductDetailedResponse {

    private UUID id;

    private String name;

    private String description;

    private String price;

    private Set<Feature> features;

    private Category category;

    private boolean isAvailable;

    private City city;

    private Set<Image> images;


}
