package com.digitalhouse.rentcar.app.api.dto.resquest.category;

import com.digitalhouse.rentcar.domain.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequest {

    @NotBlank
    @JsonProperty("qualification")
    private String qualification;

    @NotNull
    @JsonProperty("description")
    private String description;

    @NotNull
    @JsonProperty("imageUrl")
    private String imageUrl;

}
