package com.digitalhouse.rentcar.domain.repository;

import com.digitalhouse.rentcar.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImageRepository extends JpaRepository<Image, UUID> {

}
