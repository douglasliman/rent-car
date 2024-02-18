package com.digitalhouse.rentcar.app.api.controller;

import com.digitalhouse.rentcar.app.api.UserApi;
import com.digitalhouse.rentcar.app.api.dto.response.user.UserDetailedResponse;
import com.digitalhouse.rentcar.app.api.dto.response.user.UserSummaryResponse;
import com.digitalhouse.rentcar.app.api.dto.resquest.user.CreateUserRequest;
import com.digitalhouse.rentcar.domain.entity.User;
import com.digitalhouse.rentcar.domain.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;
@RestController
@CrossOrigin(origins = "*")
public class UserController implements UserApi {
    private final UserService userService;

    private final ObjectMapper mapper;

    public UserController(UserService userService, ObjectMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }
    private  UserDetailedResponse userToProductDetailedResponse(User user){
        return mapper.convertValue(user, UserDetailedResponse.class);
    }
    @Override
    public ResponseEntity<UserDetailedResponse> create(CreateUserRequest request) {
        User user = mapper.convertValue(request, User.class);
        User createdUser = userService.create(user);

        UserDetailedResponse userDetailedResponse = userToProductDetailedResponse(createdUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(userDetailedResponse);
    }

    @Override
    public ResponseEntity<Page<UserSummaryResponse>> searchAll(Pageable page) {
        Page<User> userPage = userService.searchAll(page);
        Page<UserSummaryResponse> response = userPage
                .map(user -> new UserSummaryResponse(user.getId(),user.getName(), user.getEmail()));

        return  ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<UserDetailedResponse> searchById(UUID id) {
        User  user = userService.searchById(id);
        UserDetailedResponse userDetailedResponse = userToProductDetailedResponse(user);

        return ResponseEntity.ok(userDetailedResponse);
    }

    @Override
    public ResponseEntity<UserDetailedResponse> update(UUID id, Map<String, Object> params) {
        User  user = userService.update(id,params);
        UserDetailedResponse userDetailedResponse = userToProductDetailedResponse(user);

        return ResponseEntity.accepted().body(userDetailedResponse);
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
