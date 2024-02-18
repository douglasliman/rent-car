package com.digitalhouse.rentcar.domain.service.impl;

import com.digitalhouse.rentcar.domain.entity.Booking;
import com.digitalhouse.rentcar.domain.entity.Product;
import com.digitalhouse.rentcar.domain.entity.User;
import com.digitalhouse.rentcar.domain.exception.BookingNotFoundException;
import com.digitalhouse.rentcar.domain.exception.ProductNotFoundException;
import com.digitalhouse.rentcar.domain.exception.UserNotFoundException;
import com.digitalhouse.rentcar.domain.repository.BookingRepository;
import com.digitalhouse.rentcar.domain.repository.ProductRespository;
import com.digitalhouse.rentcar.domain.repository.UserRepository;
import com.digitalhouse.rentcar.domain.service.BookingService;
import com.digitalhouse.rentcar.domain.service.ProductService;
import com.digitalhouse.rentcar.domain.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

    private final ProductRespository productRespository;

    private final UserRepository userRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, ProductRespository productRespository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.productRespository = productRespository;
        this.userRepository = userRepository;
    }

    @Override
    public Booking create(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking searchById(UUID id) {
        return bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException(id));
    }

    @Override
    public Page<Booking> searchAll(Pageable pageable) {
        return bookingRepository.findAll(pageable);
    }

    @Override
    public Booking update(UUID id, Map<String, Object> params) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException(id));

        if(params.containsKey("user")) {
            UUID userId = UUID.fromString((String) params.get("userId"));
            User user = user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
            booking.setUser(user);
        }

        if (params.containsKey("checkInTime")) {
            booking.setCheckInTime((String) params.get("checkInTime"));
        }

        if (params.containsKey("checkOutTime")) {
            booking.setCheckOutTime((String) params.get("checkOutTime"));
        }

        if (params.containsKey("productId")) {
            UUID productId = UUID.fromString((String) params.get("productId"));
            Product product = productRespository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
            booking.setProduct(product);
        }

        if (params.containsKey("isActive")) {
            booking.setIsActive((Boolean) params.get("isActive"));
        }

        return bookingRepository.save(booking);
    }

    @Override
    public void delete(UUID id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException(id));
        bookingRepository.delete(booking);
    };
}
