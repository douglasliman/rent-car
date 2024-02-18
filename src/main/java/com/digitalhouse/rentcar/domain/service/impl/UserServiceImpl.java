package com.digitalhouse.rentcar.domain.service.impl;

import com.digitalhouse.rentcar.domain.entity.User;
import com.digitalhouse.rentcar.domain.exception.UserNotFoundException;
import com.digitalhouse.rentcar.domain.repository.UserRepository;
import com.digitalhouse.rentcar.domain.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Page<User> searchAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User searchById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(UUID id, Map<String, Object> params) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

        if (params.containsKey("name")) {
            user.setName((String) params.get("name"));
        }
        if (params.containsKey("surname")) {
            user.setSurname((String) params.get("surname"));
        }
        if (params.containsKey("email")) {
            user.setEmail((String) params.get("email"));
        }
        if (params.containsKey("password")) {
            user.setPassword((String) params.get("password"));
        }

        return userRepository.save(user);

    }

    @Override
    public void delete(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(user);
    }
}
