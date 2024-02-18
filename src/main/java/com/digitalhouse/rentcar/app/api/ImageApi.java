package com.digitalhouse.rentcar.app.api;

import com.digitalhouse.rentcar.app.api.dto.response.image.ImageDetailedResponse;
import com.digitalhouse.rentcar.app.api.dto.resquest.image.CreateImageRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

public interface ImageApi {

    @Operation(summary = "Cria uma image", method = "POST")
    @PostMapping
    ResponseEntity<ImageDetailedResponse> create(@RequestBody CreateImageRequest request);

    @Operation(summary = "Busca todas as images", method = "GET")
    @GetMapping
    ResponseEntity<Page<ImageDetailedResponse>> searchAll(@PageableDefault Pageable page);

    @Operation(summary = "Busca uma image por id", method = "GET")
    @GetMapping("{id}")
    ResponseEntity<ImageDetailedResponse> searchById(@PathVariable UUID id);

    @Operation(summary = "Atualiza uma image por id", method = "PATCH")
    @PatchMapping("{id}")
    ResponseEntity<ImageDetailedResponse> update(@PathVariable UUID id, @RequestBody  Map<String, Object> params);

    @Operation(summary = "deleta uma image", method = "DELETE")
    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);

}
