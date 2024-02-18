package com.digitalhouse.rentcar.domain.service;

import com.digitalhouse.rentcar.domain.entity.Category;
import com.digitalhouse.rentcar.domain.entity.Feature;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;
import java.util.UUID;

public interface FeatureService {
    Page<Feature> searchAll(Pageable pageable);

    Feature searchById(UUID id);

    Feature create(Feature feature);

    Feature update(UUID id, Map<String, Object> params);

    void delete(UUID id);

}
