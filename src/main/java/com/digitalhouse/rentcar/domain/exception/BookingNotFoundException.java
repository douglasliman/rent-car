package com.digitalhouse.rentcar.domain.exception;

import java.util.UUID;

public class BookingNotFoundException extends RuntimeException {

    public BookingNotFoundException(UUID id) {
        super("%s not found!".formatted(id));
    }
}
