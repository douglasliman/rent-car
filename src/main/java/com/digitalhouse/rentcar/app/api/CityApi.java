package com.digitalhouse.rentcar.app.api;

import com.digitalhouse.rentcar.app.api.dto.response.city.CityDetailedResponse;
import com.digitalhouse.rentcar.app.api.dto.response.city.CitySummaryResponse;
import com.digitalhouse.rentcar.app.api.dto.resquest.city.CreateCityRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/cities")
@Tag(name = "Cidades")
public interface  CityApi {
    @Operation(summary = "Cria uma cidade", method = "POST")

    @PostMapping
    ResponseEntity<CityDetailedResponse> create(@RequestBody CreateCityRequest request);

    @Operation(summary = "Busca todas as cidades", method = "GET")
    @GetMapping
    ResponseEntity<Page<CitySummaryResponse>> searchAll(@PageableDefault Pageable page);
}
