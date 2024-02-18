package com.digitalhouse.rentcar.app.api.dto.resquest.feature;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class CreateFeatureRequest {

    @NotBlank
    @JsonProperty("name")
    private String name;

}
