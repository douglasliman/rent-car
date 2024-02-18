package com.digitalhouse.rentcar.app.api.dto.response.feature;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.NoArgsConstructor;

import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeatureDetailedResponse {

    private UUID id;

    private String name;

    private String url;

}
