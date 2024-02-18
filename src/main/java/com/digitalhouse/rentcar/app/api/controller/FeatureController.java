package com.digitalhouse.rentcar.app.api.controller;

import com.digitalhouse.rentcar.app.api.FeatureApi;
import com.digitalhouse.rentcar.app.api.dto.response.category.CategoryDetailedResponse;
import com.digitalhouse.rentcar.app.api.dto.response.category.CategorySummaryResponse;
import com.digitalhouse.rentcar.app.api.dto.response.feature.FeatureDetailedResponse;
import com.digitalhouse.rentcar.app.api.dto.response.product.ProductDetailedResponse;
import com.digitalhouse.rentcar.app.api.dto.resquest.feature.CreateFeatureRequest;
import com.digitalhouse.rentcar.domain.entity.Category;
import com.digitalhouse.rentcar.domain.entity.Feature;
import com.digitalhouse.rentcar.domain.entity.Product;
import com.digitalhouse.rentcar.domain.service.FeatureService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
public class FeatureController implements FeatureApi {
    private final FeatureService featureService;

    private final ObjectMapper mapper;

    private FeatureDetailedResponse  featureToCategoryDetailedResponse(Feature feature) {
        return mapper.convertValue(feature, FeatureDetailedResponse.class);
    }

    public FeatureController(FeatureService featureService, ObjectMapper mapper) {
        this.featureService = featureService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<FeatureDetailedResponse> create(CreateFeatureRequest request) {
        Feature feature = mapper.convertValue(request, Feature.class);
        Feature createdFeature = featureService.create(feature);

        FeatureDetailedResponse featureDetailedResponse = featureToCategoryDetailedResponse(createdFeature);

        return ResponseEntity.status(HttpStatus.CREATED).body(featureDetailedResponse);
    }

    @Override
    public ResponseEntity<Page<FeatureDetailedResponse>> searchAll(Pageable pageable) {
        Page<Feature> featurePage = featureService.searchAll(pageable);
        Page<FeatureDetailedResponse> response = featurePage
                .map(feature -> new FeatureDetailedResponse(feature.getId(), feature.getName(), feature.getUrl()));

        return ResponseEntity.ok(response);
    }


    @Override
    public ResponseEntity<FeatureDetailedResponse> searchById(UUID id) {
        Feature feature = featureService.searchById(id);
        FeatureDetailedResponse featureDetailedResponse = featureToFeatureDetailedResponse(feature);

        return ResponseEntity.ok(featureDetailedResponse);
    }

    @Override
    public ResponseEntity<FeatureDetailedResponse> update(UUID id, Map<String, Object> params) {
        Feature feature = featureService.update(id,params);
        FeatureDetailedResponse featureDetailedResponse = featureToFeatureDetailedResponse(feature);

        return ResponseEntity.accepted().body(featureDetailedResponse);
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        featureService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private FeatureDetailedResponse featureToFeatureDetailedResponse(Feature feature) {
        return mapper.convertValue(feature, FeatureDetailedResponse.class);
    }
}
