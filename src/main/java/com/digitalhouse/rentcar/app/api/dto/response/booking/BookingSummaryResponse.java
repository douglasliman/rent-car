package com.digitalhouse.rentcar.app.api.dto.response.booking;

import com.digitalhouse.rentcar.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
public class BookingSummaryResponse {

    private UUID id;

    String checkInTime;

    String checkOutTime;

    private Product product;

    private boolean isActive;

}
