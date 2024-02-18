package com.digitalhouse.rentcar.app.api.dto.resquest.user;

import com.digitalhouse.rentcar.domain.entity.EnumRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
@Schema(hidden = true)
public class CreateUserRequest {
    @NotBlank
    @JsonProperty("name")
    private String name;
    @NotBlank
    @JsonProperty("surname")
    private String surname;
    @NotBlank
    @JsonProperty("email")
    private String email;
    @NotBlank
    @JsonProperty("password")
    private String password;
    @NotBlank
    @JsonProperty("role")
    private EnumRole role;
}
