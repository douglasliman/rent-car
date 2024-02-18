package com.digitalhouse.rentcar.domain.service.impl;

import com.digitalhouse.rentcar.domain.entity.Category;
import com.digitalhouse.rentcar.domain.exception.CategoryNotFoundException;
import com.digitalhouse.rentcar.domain.repository.CategoryRepository;
import com.digitalhouse.rentcar.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public Category searchById(UUID id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
    }

    public Page<Category> searchAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Transactional
    public Category update(UUID id, Map<String, Object> params) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));

        if (params.containsKey("qualification")) {
            category.setQualification((String) params.get("qualification"));
        }
        if (params.containsKey("description")) {
            category.setDescription((String) params.get("description"));
        }
        if (params.containsKey("imageUrl")) {
            category.setImageUrl((String) params.get("imageUrl"));
        }

        return categoryRepository.save(category);
    }

    public void delete(UUID id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
        categoryRepository.delete(category);
    }

}
