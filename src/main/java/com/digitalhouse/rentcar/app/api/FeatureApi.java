package com.digitalhouse.rentcar.app.api;

import com.digitalhouse.rentcar.app.api.dto.response.category.CategoryDetailedResponse;
import com.digitalhouse.rentcar.app.api.dto.response.category.CategorySummaryResponse;
import com.digitalhouse.rentcar.app.api.dto.response.feature.FeatureDetailedResponse;
import com.digitalhouse.rentcar.app.api.dto.resquest.category.CreateCategoryRequest;
import com.digitalhouse.rentcar.app.api.dto.resquest.feature.CreateFeatureRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;
@RequestMapping("/v1/features")
@Tag(name = "Feature")
public interface FeatureApi {
    @Operation(summary = "Cria uma feature", method = "POST")
    @PostMapping
    ResponseEntity<FeatureDetailedResponse> create(@RequestBody CreateFeatureRequest request);

    @Operation(summary = "Busca todas as features", method = "GET")
    @GetMapping
    ResponseEntity<Page<FeatureDetailedResponse>> searchAll(@PageableDefault Pageable page);

    @Operation(summary = "Busca uma feature por id", method = "GET")
    @GetMapping("{id}")
    ResponseEntity<FeatureDetailedResponse> searchById(@PathVariable UUID id);

    @Operation(summary = "Atualiza uma feature por id", method = "PATCH")
    @PatchMapping("{id}")
    ResponseEntity<FeatureDetailedResponse> update(@PathVariable UUID id, Map<String, Object> params);

    @Operation(summary = "deleta uma feature", method = "DELETE")
    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);

}
