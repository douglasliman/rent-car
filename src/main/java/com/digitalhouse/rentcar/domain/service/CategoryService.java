package com.digitalhouse.rentcar.domain.service;

import com.digitalhouse.rentcar.domain.entity.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;
import java.util.UUID;

public interface CategoryService {
    Page<Category> searchAll(Pageable pageable);

    Category searchById(UUID id);

    Category create(Category category);

    Category update(UUID id, Map<String, Object> params);

    void delete(UUID id);
}
