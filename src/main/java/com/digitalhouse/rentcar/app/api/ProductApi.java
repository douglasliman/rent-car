package com.digitalhouse.rentcar.app.api;

import com.digitalhouse.rentcar.app.api.dto.response.product.ProductDetailedResponse;
import com.digitalhouse.rentcar.app.api.dto.resquest.product.CreateProductRequest;
import com.digitalhouse.rentcar.domain.entity.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/v1/products")
@Tag(name = "Produtos")
public interface ProductApi {
    @Operation(summary = "Cria um produto", method = "POST")
    @SecurityRequirement(name = "bearerAuth", scopes = {"admin"})
    @PostMapping
    ResponseEntity<ProductDetailedResponse> create(@RequestBody CreateProductRequest request);

    @Operation(summary = "Busca todos os produtos", method = "GET")
    @GetMapping
    ResponseEntity<Page<ProductDetailedResponse>> searchAll(@PageableDefault Pageable page);

    @Operation(summary = "Busca um produto por id", method = "GET")
    @GetMapping(value = "{id}")
    ResponseEntity<ProductDetailedResponse> searchById(@PathVariable UUID id);

    @GetMapping("/buscar/categorias/{id}")
    ResponseEntity<List<Product>> searchByCategory(@PathVariable UUID id);

    @GetMapping("/buscar/cidades/{id}")
    ResponseEntity<List<Product>> searchByCity(@PathVariable UUID id);

    @Operation(summary = "Atualiza um produto por id", method = "PATCH")
    @PatchMapping("{id}")
    ResponseEntity<ProductDetailedResponse> update(@PathVariable UUID id, @RequestBody Map<String, Object> params);

    @Operation(summary = "deleta um produto", method = "DELETE")
    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);



}
