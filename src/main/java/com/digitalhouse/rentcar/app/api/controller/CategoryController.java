package com.digitalhouse.rentcar.app.api.controller;

import com.digitalhouse.rentcar.app.api.CategoryApi;
import com.digitalhouse.rentcar.app.api.dto.response.category.CategoryDetailedResponse;
import com.digitalhouse.rentcar.app.api.dto.response.category.CategorySummaryResponse;
import com.digitalhouse.rentcar.app.api.dto.resquest.category.CreateCategoryRequest;
import com.digitalhouse.rentcar.domain.entity.Category;
import com.digitalhouse.rentcar.domain.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController implements CategoryApi {
    private final CategoryService categoryService;
    private final ObjectMapper mapper;

    public CategoryController(CategoryService categoryService, ObjectMapper mapper) {
        this.categoryService = categoryService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<CategoryDetailedResponse> create(CreateCategoryRequest request) {
        Category category = mapper.convertValue(request, Category.class);
        Category createdCategory = categoryService.create(category);

        CategoryDetailedResponse categoryDetailedResponse = categoryToCategoryDetailedResponse(createdCategory);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDetailedResponse);
    }

    @Override
    public ResponseEntity<Page<CategorySummaryResponse>> searchAll(Pageable pageable) {
        Page<Category> categoryPage = categoryService.searchAll(pageable);
        Page<CategorySummaryResponse> response = categoryPage
                .map(category -> new CategorySummaryResponse(category.getId(), category.getQualification()));

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<CategoryDetailedResponse> searchById(UUID id) {
        Category category = categoryService.searchById(id);
        CategoryDetailedResponse categoryDetailedResponse = categoryToCategoryDetailedResponse(category);

        return ResponseEntity.ok(categoryDetailedResponse);
    }

    @Override
    public ResponseEntity<CategoryDetailedResponse> update(UUID id, Map<String, Object> params) {
        Category category = categoryService.update(id, params);
        CategoryDetailedResponse categoryDetailedResponse = categoryToCategoryDetailedResponse(category);

        return ResponseEntity.ok(categoryDetailedResponse);
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }



    private CategoryDetailedResponse categoryToCategoryDetailedResponse(Category category) {
        return mapper.convertValue(category, CategoryDetailedResponse.class);
    }
}
