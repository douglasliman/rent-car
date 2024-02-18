package com.digitalhouse.rentcar.domain.exception;

import java.util.UUID;

public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException(UUID id) {
        super("%s not found!".formatted(id));
    }

}
