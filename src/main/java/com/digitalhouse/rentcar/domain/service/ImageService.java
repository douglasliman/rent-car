package com.digitalhouse.rentcar.domain.service;

import com.digitalhouse.rentcar.domain.entity.Category;
import com.digitalhouse.rentcar.domain.entity.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;
import java.util.UUID;

public interface ImageService {

    Page<Image> searchAll(Pageable pageable);

    Image searchById(UUID id);

    Image create(Image image);

    Image update(UUID id, Map<String, Object> params);

    void delete(UUID id);
}
