package com.digitalhouse.rentcar.domain.exception;

import java.util.UUID;

public class FeatureNotFoundException extends  RuntimeException{

    public FeatureNotFoundException(UUID id) {
        super("%s not found!".formatted(id));
    }

}
