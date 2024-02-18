package com.digitalhouse.rentcar.app.api.dto.resquest.city;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateCityRequest {
    @NotBlank
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("state")
    private String state;

    @NotNull
    @JsonProperty("country")
    private String country;
}
