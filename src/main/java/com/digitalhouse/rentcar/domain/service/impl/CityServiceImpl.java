package com.digitalhouse.rentcar.domain.service.impl;

import com.digitalhouse.rentcar.domain.entity.City;
import com.digitalhouse.rentcar.domain.repository.CityRepository;
import com.digitalhouse.rentcar.domain.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Page<City> searchAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public City create(City city) {
        return cityRepository.save(city);
    }

}
