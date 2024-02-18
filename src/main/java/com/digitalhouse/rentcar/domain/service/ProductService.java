package com.digitalhouse.rentcar.domain.service;


import com.digitalhouse.rentcar.app.api.dto.response.product.ProductDetailedResponse;
import com.digitalhouse.rentcar.domain.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ProductService {

   Page<Product> searchAll(Pageable pageable);

   Product searchById(UUID id);

   List<Product> searchByCategory(UUID id);

   List<Product> searchByCity(UUID id);

   Product create(Product product);

   Product update(UUID id, Map<String, Object> params);

   void delete(UUID id);

}
