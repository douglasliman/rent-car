package com.digitalhouse.rentcar.domain.repository;

import com.digitalhouse.rentcar.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import org.springframework.security.core.userdetails.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    UserDetails findByEmail(String email);

}
