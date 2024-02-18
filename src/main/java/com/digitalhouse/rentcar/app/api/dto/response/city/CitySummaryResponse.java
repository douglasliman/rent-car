package com.digitalhouse.rentcar.app.api.dto.response.city;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CitySummaryResponse {

    private UUID id;

    private String name;

    private String state;
}
