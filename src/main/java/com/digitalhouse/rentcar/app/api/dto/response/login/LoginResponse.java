package com.digitalhouse.rentcar.app.api.dto.response.login;

import java.util.UUID;

public record LoginResponse(String token, String name, String surname, UUID id,String email) {
}