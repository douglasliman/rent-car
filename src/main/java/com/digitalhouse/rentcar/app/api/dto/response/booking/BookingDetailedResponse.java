package com.digitalhouse.rentcar.app.api.dto.response.booking;

import com.digitalhouse.rentcar.domain.entity.Product;
import com.digitalhouse.rentcar.domain.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;
@Getter
@Setter
public class BookingDetailedResponse {

    private UUID id;

    private User user;

    private String checkInTime;

    private String checkOutTime;

    private Product product;

    private boolean isActive;

}
