package com.digitalhouse.rentcar.domain.exception;

import java.util.UUID;

public class UserNotFoundException  extends RuntimeException{

    public UserNotFoundException(UUID id) {
        super("%s not found!".formatted(id));
    }
}
