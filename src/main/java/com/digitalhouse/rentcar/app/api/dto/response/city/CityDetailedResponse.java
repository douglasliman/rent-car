package com.digitalhouse.rentcar.app.api.dto.response.city;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CityDetailedResponse {

    private UUID id;

    private String name;

    private String state;

    private String country;
}
