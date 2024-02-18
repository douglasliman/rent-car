package com.digitalhouse.rentcar.app.api.controller;

import com.digitalhouse.rentcar.app.api.CityApi;
import com.digitalhouse.rentcar.app.api.dto.response.city.CityDetailedResponse;
import com.digitalhouse.rentcar.app.api.dto.response.city.CitySummaryResponse;
import com.digitalhouse.rentcar.app.api.dto.resquest.city.CreateCityRequest;
import com.digitalhouse.rentcar.domain.entity.City;
import com.digitalhouse.rentcar.domain.service.CityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class CityController implements CityApi {
    private final CityService cityService;
    private final ObjectMapper mapper;

    public CityController(CityService cityService, ObjectMapper mapper) {
        this.cityService = cityService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<CityDetailedResponse> create(CreateCityRequest request) {
        City city = mapper.convertValue(request, City.class);
        City createdCity = cityService.create(city);

        CityDetailedResponse cityDetailedResponse = cityToCityDetailedResponse(createdCity);

        return ResponseEntity.status(HttpStatus.CREATED).body(cityDetailedResponse);
    }

    @Override
    public ResponseEntity<Page<CitySummaryResponse>> searchAll(Pageable page) {
        Page<City> cityPage = cityService.searchAll(page);

        Page<CitySummaryResponse> response = cityPage
                .map(city -> new CitySummaryResponse(city.getId(), city.getName(), city.getState()));
        return ResponseEntity.ok(response);
    }

    private CityDetailedResponse cityToCityDetailedResponse(City city) {
        return mapper.convertValue(city, CityDetailedResponse.class);
    }
}
