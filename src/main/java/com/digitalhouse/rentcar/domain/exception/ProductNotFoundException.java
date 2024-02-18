package com.digitalhouse.rentcar.domain.exception;

import java.util.UUID;

public class ProductNotFoundException extends  RuntimeException{

    public ProductNotFoundException(UUID id) {
        super("%s not found!".formatted(id));
    }

}
