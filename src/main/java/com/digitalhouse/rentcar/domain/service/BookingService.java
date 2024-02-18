package com.digitalhouse.rentcar.domain.service;

import com.digitalhouse.rentcar.domain.entity.Booking;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;
import java.util.UUID;

public interface BookingService {
    Page<Booking> searchAll(Pageable pageable);

    Booking searchById(UUID id);

    Booking create(Booking booking);

    Booking update(UUID id, Map<String, Object> params);

    void delete(UUID id);
}
