package com.digitalhouse.rentcar.domain.service.impl;

import com.digitalhouse.rentcar.domain.entity.Feature;
import com.digitalhouse.rentcar.domain.exception.FeatureNotFoundException;
import com.digitalhouse.rentcar.domain.repository.FeatureRepository;
import com.digitalhouse.rentcar.domain.service.FeatureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class FeatureServiceImpl implements FeatureService {
    private final FeatureRepository featureRepository;

    public FeatureServiceImpl(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    @Override
    public Page<Feature> searchAll(Pageable pageable) {
        return featureRepository.findAll(pageable);
    }

    @Override
    public Feature searchById(UUID id) {
        return featureRepository.findById(id).orElseThrow(() -> new FeatureNotFoundException(id));
    }

    @Override
    public Feature create(Feature feature) {
        return featureRepository.save(feature);
    }

    @Override
    public Feature update(UUID id, Map<String, Object> params) {
        Feature feature = featureRepository.findById(id).orElseThrow(() -> new FeatureNotFoundException(id));

        for (String key : params.keySet()) {
            Object value = params.get(key);

            switch (key) {
                case "name":
                    feature.setName((String) value);
                    break;
            }
        }

        return featureRepository.save(feature);
    }

    @Override
    public void delete(UUID id) {

    }
}
