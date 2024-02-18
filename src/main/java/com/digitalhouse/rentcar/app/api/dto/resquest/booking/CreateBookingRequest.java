package com.digitalhouse.rentcar.app.api.dto.resquest.booking;

import com.digitalhouse.rentcar.domain.entity.Product;
import com.digitalhouse.rentcar.domain.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookingRequest {
    @JsonProperty("user")
    private User user;

    @JsonProperty("checkInTime")
    String checkInTime;

    @JsonProperty("checkOutTime")
    String checkOutTime;

    @JsonProperty("product")
    private Product product;

    @JsonProperty("isActive")
    private Boolean isActive;
}
