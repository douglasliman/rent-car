package com.digitalhouse.rentcar.domain.exception;

import java.util.UUID;

public class  CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(UUID id) {
        super("%s not found!".formatted(id));
    }

}
