package com.digitalhouse.rentcar.app.api.dto.resquest.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateImageRequest {
    @NotBlank
    @JsonProperty("title")
    private String title;

    @NotBlank
    @JsonProperty("url")
    private String url;
}
