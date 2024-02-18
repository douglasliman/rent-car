package com.digitalhouse.rentcar.domain.repository;

import com.digitalhouse.rentcar.app.api.dto.response.product.ProductDetailedResponse;
import com.digitalhouse.rentcar.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRespository extends JpaRepository<Product, UUID> {
    List<Product> findByCategory_Id(UUID categoryId);

    public List<Product> findByCity_Id(UUID cityId);


}


