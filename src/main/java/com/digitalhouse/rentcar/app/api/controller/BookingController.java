package com.digitalhouse.rentcar.app.api.controller;

import com.digitalhouse.rentcar.app.api.BookingApi;
import com.digitalhouse.rentcar.app.api.dto.response.booking.BookingDetailedResponse;
import com.digitalhouse.rentcar.app.api.dto.response.booking.BookingSummaryResponse;
import com.digitalhouse.rentcar.app.api.dto.resquest.booking.CreateBookingRequest;
import com.digitalhouse.rentcar.domain.entity.Booking;
import com.digitalhouse.rentcar.domain.entity.Product;
import com.digitalhouse.rentcar.domain.entity.User;
import com.digitalhouse.rentcar.domain.service.BookingService;
import com.digitalhouse.rentcar.domain.service.ProductService;
import com.digitalhouse.rentcar.domain.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
public class BookingController implements BookingApi {
    private final BookingService bookingService;

    private final ObjectMapper mapper;

    public BookingController(BookingService bookingService, UserService userService, ProductService productService, ObjectMapper mapper) {
        this.bookingService = bookingService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<BookingDetailedResponse> create(CreateBookingRequest request) {

        Booking booking = mapper.convertValue(request, Booking.class);
        booking.setIsActive(true);
        Booking createdBooking = bookingService.create(booking);

        BookingDetailedResponse detailedResponse = bookingToBookingDetailedResponse(createdBooking);

        return ResponseEntity.status(HttpStatus.CREATED).body(detailedResponse);
    }


    @Override
    public ResponseEntity<Page<BookingSummaryResponse>> searchAll(Pageable pageable) {
        Page<Booking> bookingPage = bookingService.searchAll(pageable);
        Page<BookingSummaryResponse> response = bookingPage
                .map(booking -> new BookingSummaryResponse(booking.getId(), booking.getCheckInTime(), booking.getCheckOutTime(),booking.getProduct(), booking.getIsActive()));

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<BookingDetailedResponse> searchById(UUID id) {
        Booking booking = bookingService.searchById(id);

        BookingDetailedResponse bookingDetailedResponse = bookingToBookingDetailedResponse(booking);

        return ResponseEntity.ok(bookingDetailedResponse);
    }

    @Override
    public ResponseEntity<BookingDetailedResponse> update(UUID id, Map<String, Object> params) {
        Booking booking = bookingService.update(id, params);

        BookingDetailedResponse detailedResponse = bookingToBookingDetailedResponse(booking);

        return ResponseEntity.ok(detailedResponse);
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        bookingService.delete(id);

        return ResponseEntity.noContent().build();
    }

    private BookingDetailedResponse bookingToBookingDetailedResponse(Booking booking) {
        return mapper.convertValue(booking, BookingDetailedResponse.class);
    }







}
