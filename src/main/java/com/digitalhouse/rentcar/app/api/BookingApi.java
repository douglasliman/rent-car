package com.digitalhouse.rentcar.app.api;

import com.digitalhouse.rentcar.app.api.dto.resquest.booking.CreateBookingRequest;
import com.digitalhouse.rentcar.app.api.dto.response.booking.BookingDetailedResponse;
import com.digitalhouse.rentcar.app.api.dto.response.booking.BookingSummaryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RequestMapping("/v1/bookings")
@Tag(name = "Reserva")
public interface BookingApi {
    @Operation(summary = "Cria uma reserva", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva criada com sucesso")
    })
    @PostMapping
    ResponseEntity<BookingDetailedResponse> create(@RequestBody CreateBookingRequest request);

    @Operation(summary = "Busca todas as reservas", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservas buscadas com sucesso")
    })
    @GetMapping
    ResponseEntity<Page<BookingSummaryResponse>> searchAll(@PageableDefault Pageable page);

    @Operation(summary = "Busca uma reserva por id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva buscada com sucesso")
    })

    @GetMapping("{id}")
    ResponseEntity<BookingDetailedResponse> searchById(@PathVariable UUID id);

    @Operation(summary = "Atualiza uma reserva por id", method = "PATCH")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva atualizada com sucesso")
    })
    @PatchMapping("{id}")
    ResponseEntity<BookingDetailedResponse> update(@PathVariable UUID id, @RequestBody Map<String, Object> params);

    @Operation(summary = "Deleta uma reserva", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva deletada com sucesso")
    })
    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);
}
