package com.digitalhouse.rentcar.app.api.dto.response.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CategorySummaryResponse {

    private UUID id;

    private String qualification;
}
