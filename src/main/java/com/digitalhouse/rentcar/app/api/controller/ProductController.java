package com.digitalhouse.rentcar.app.api.controller;

import com.digitalhouse.rentcar.app.api.ProductApi;

import com.digitalhouse.rentcar.app.api.dto.response.feature.FeatureDetailedResponse;
import com.digitalhouse.rentcar.app.api.dto.response.image.ImageDetailedResponse;
import com.digitalhouse.rentcar.app.api.dto.response.product.ProductDetailedResponse;
import com.digitalhouse.rentcar.app.api.dto.resquest.product.CreateProductRequest;

import com.digitalhouse.rentcar.domain.entity.Feature;
import com.digitalhouse.rentcar.domain.entity.Image;
import com.digitalhouse.rentcar.domain.entity.Product;
import com.digitalhouse.rentcar.domain.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class ProductController implements ProductApi {
    private final ProductService productService;

    private final ObjectMapper mapper;

    public ProductController(ProductService productService, ObjectMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<ProductDetailedResponse> create(CreateProductRequest request) {
        Product product = mapper.convertValue(request, Product.class);
        Product createdProduct= productService.create(product);

        ProductDetailedResponse productDetailedResponse = productToProductDetailedResponse(createdProduct);

        return ResponseEntity.status(HttpStatus.CREATED).body(productDetailedResponse);
    }

    @Override
    public ResponseEntity<Page<ProductDetailedResponse>> searchAll(Pageable page) {
        page = PageRequest.of(page.getPageNumber(), 20);
        Page<Product> productPage = productService.searchAll(page);
        Page<ProductDetailedResponse> detailedResponse = productPage
                .map(product -> new ProductDetailedResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice(),
                        product.getFeatures(), product.getCategory(), product.isAvailable(), product.getCity(), product.getImages()));

        return ResponseEntity.ok(detailedResponse);
    }

    @Override
    public ResponseEntity<ProductDetailedResponse> searchById(UUID id) {
        Product product = productService.searchById(id);
        ProductDetailedResponse productDetailedResponse = productToProductDetailedResponse(product);
        return ResponseEntity.ok(productDetailedResponse);
    }

    @Override
    public ResponseEntity<List<Product>> searchByCategory(UUID id) {
        List<Product> responseList = productService.searchByCategory(id);
        return ResponseEntity.ok(responseList);
    }

    @Override
    public ResponseEntity<List<Product>> searchByCity(UUID id) {
        List<Product> responseList = productService.searchByCity(id);
        return ResponseEntity.ok(responseList);
    }

    @Override
    public ResponseEntity<ProductDetailedResponse> update(UUID id, Map<String, Object> params) {
        Product product = productService.update(id,params);
        ProductDetailedResponse productDetailedResponse = productToProductDetailedResponse(product);

        return ResponseEntity.accepted().body(productDetailedResponse);
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ProductDetailedResponse productToProductDetailedResponse(Product product) {
        ProductDetailedResponse response = mapper.convertValue(product, ProductDetailedResponse.class);


        Set<FeatureDetailedResponse> featureResponses = product.getFeatures().stream()
                .map(this::featureToFeatureResponse)
                .collect(Collectors.toSet());


        Set<Feature> features = featureResponses.stream()
                .map(feature -> mapper.convertValue(feature, Feature.class))
                .collect(Collectors.toSet());

        response.setFeatures(features);


        Set<ImageDetailedResponse> imageResponses = product.getImages().stream()
                .map(this::imageToImageResponse)
                .collect(Collectors.toSet());


        Set<Image> images = imageResponses.stream()
                .map(image -> mapper.convertValue(image, Image.class))
                .collect(Collectors.toSet());

        response.setImages(images);

        return response;
    }

    private FeatureDetailedResponse featureToFeatureResponse(Feature feature) {
        return mapper.convertValue(feature, FeatureDetailedResponse.class);
    }

    private ImageDetailedResponse imageToImageResponse(Image image) {
        return mapper.convertValue(image, ImageDetailedResponse.class);
    }

}
