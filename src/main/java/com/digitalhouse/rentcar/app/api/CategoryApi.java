package com.digitalhouse.rentcar.app.api;
import com.digitalhouse.rentcar.app.api.dto.response.category.CategoryDetailedResponse;
import com.digitalhouse.rentcar.app.api.dto.response.category.CategorySummaryResponse;
import com.digitalhouse.rentcar.app.api.dto.resquest.category.CreateCategoryRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RequestMapping("/v1/categories")
@Tag(name = "Categoria")
public interface CategoryApi {
    @Operation(summary = "Cria uma categoria", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria criada com sucesso")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CategoryDetailedResponse> create(@RequestBody CreateCategoryRequest request);

    @Operation(summary = "Busca todas as categorias", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categorias buscadas com sucesso")
    })
    @GetMapping
    ResponseEntity<Page<CategorySummaryResponse>> searchAll(@PageableDefault Pageable page);

    @Operation(summary = "Busca uma cateogira por id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria criada com sucesso")
    })
    @GetMapping("{id}")
    ResponseEntity<CategoryDetailedResponse> searchById(@PathVariable UUID id);

    @Operation(summary = "Atualiza uma categoria por id", method = "PATCH")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria criada com sucesso")
    })
    @PatchMapping("{id}")
    ResponseEntity<CategoryDetailedResponse> update(@PathVariable UUID id, @RequestBody Map<String, Object> params);


    @Operation(summary = "deleta uma categoria", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria criada com sucesso")
    })
    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);


}
