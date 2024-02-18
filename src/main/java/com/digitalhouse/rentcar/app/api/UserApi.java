package com.digitalhouse.rentcar.app.api;


import com.digitalhouse.rentcar.app.api.dto.response.user.UserDetailedResponse;

import com.digitalhouse.rentcar.app.api.dto.response.user.UserSummaryResponse;
import com.digitalhouse.rentcar.app.api.dto.resquest.user.CreateUserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RequestMapping("/v1/users")
@Tag(name = "Usuarios")
public interface UserApi {
    @Operation(summary = "Cria um usuário", method = "POST")
    @PostMapping
    ResponseEntity<UserDetailedResponse> create(@RequestBody CreateUserRequest request);

    @Operation(summary = "Busca todos os usuários", method = "GET")
    @GetMapping
    ResponseEntity<Page<UserSummaryResponse>> searchAll(@PageableDefault Pageable page);

    @Operation(summary = "Busca um usuário por id", method = "GET")
    @GetMapping(value = "{id}")
    ResponseEntity<UserDetailedResponse> searchById(@PathVariable UUID id);


    @Operation(summary = "Atualiza um usuário por id", method = "PATCH")
    @PatchMapping("{id}")
    ResponseEntity<UserDetailedResponse> update(@PathVariable UUID id, @RequestBody Map<String, Object> params);

    @Operation(summary = "deleta um usuário", method = "DELETE")
    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);

}
