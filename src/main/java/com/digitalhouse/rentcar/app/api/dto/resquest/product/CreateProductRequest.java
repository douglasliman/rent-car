package com.digitalhouse.rentcar.app.api.dto.resquest.product;

import com.digitalhouse.rentcar.domain.entity.Feature;
import com.digitalhouse.rentcar.domain.entity.Image;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class CreateProductRequest {

    @NotBlank
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("description")
    private String description;

    @NotNull
    @JsonProperty("price")
    private String price;

    @NotNull
    @JsonProperty("isAvailable")
    private boolean isAvailable;

    @NotNull
    @JsonProperty("categoryId")
    private UUID categoryId;

    @NotNull
    @JsonProperty("cityId")
    private UUID cityId;

    @JsonProperty("features")
    private Set<Feature> features;

    @JsonProperty("images")
    private Set<Image> images;

}