package com.digitalhouse.rentcar.domain.service.impl;

import com.digitalhouse.rentcar.app.api.dto.response.product.ProductDetailedResponse;
import com.digitalhouse.rentcar.domain.entity.Product;
import com.digitalhouse.rentcar.domain.exception.ProductNotFoundException;
import com.digitalhouse.rentcar.domain.repository.ProductRespository;
import com.digitalhouse.rentcar.domain.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRespository productRespository;

    @Autowired
    public ProductServiceImpl(ProductRespository productRespository) {
        this.productRespository = productRespository;
    }

    @Override
    public Product create(Product product) {
        return productRespository.save(product);
    }
    @Override
    public Product searchById(UUID id) {
        return productRespository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

    }

    @Override
    public List<Product> searchByCategory(UUID categoryId) {

        return productRespository.findByCategory_Id(categoryId);
    }

    @Override
    public List<Product> searchByCity(UUID cityId) {
        return productRespository.findByCity_Id(cityId);
    }

    @Override
    public Page<Product> searchAll(Pageable pageable) {
        return productRespository.findAll(pageable);
    }

    @Override
    public Product update(UUID id, Map<String, Object> params) {
        Product product = productRespository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        if (params.containsKey("name")) {
            product.setName((String) params.get("name"));
        }
        if (params.containsKey("description")) {
            product.setDescription((String) params.get("description"));
        }
        if (params.containsKey("price")){
            product.setPrice((String) params.get("price"));
        }
        if (params.containsKey(params.get("features"))) {
            product.setAvailable((Boolean) params.get("features"));
        }
        if (params.containsKey(params.get("city"))) {
            product.setAvailable((Boolean) params.get("city"));
        }
        if (params.containsKey(params.get("images"))) {
            product.setAvailable((Boolean) params.get("images"));
        }

        return productRespository.save(product);
    }

    @Override
    public void delete(UUID id) {
        Product product = productRespository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        productRespository.delete(product);
    }

}
