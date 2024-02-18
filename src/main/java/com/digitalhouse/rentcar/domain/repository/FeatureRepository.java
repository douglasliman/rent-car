package com.digitalhouse.rentcar.domain.repository;

import com.digitalhouse.rentcar.domain.entity.Feature;
import com.digitalhouse.rentcar.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, UUID> {

}
