package com.digitalhouse.rentcar.domain.service;

import com.digitalhouse.rentcar.domain.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {
    Page<City> searchAll (Pageable pageable);

    City create (City city);
}
