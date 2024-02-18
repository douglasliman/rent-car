package com.digitalhouse.rentcar.app.api.dto.response.category;

import com.digitalhouse.rentcar.domain.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class CategoryDetailedResponse {

    private UUID id;

    private String qualification;

    private String description;

    private String imageUrl;

    private Set<Product> product;
}
