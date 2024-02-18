package com.digitalhouse.rentcar.domain.service;

import com.digitalhouse.rentcar.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;
import java.util.UUID;

public interface UserService {
    Page<User> searchAll(Pageable pageable);

    User searchById(UUID id);

    User create(User user);

    User update(UUID id, Map<String, Object> params);

    void delete(UUID id);
}
