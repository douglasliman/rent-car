package com.digitalhouse.rentcar.app.api.controller;

import com.digitalhouse.rentcar.app.api.dto.response.login.LoginResponse;
import com.digitalhouse.rentcar.domain.entity.User;
import com.digitalhouse.rentcar.domain.repository.UserRepository;
import com.digitalhouse.rentcar.domain.security.authConfig.CreateRegister;
import com.digitalhouse.rentcar.domain.security.authConfig.CreatedAuthetication;
import com.digitalhouse.rentcar.domain.security.token.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid CreatedAuthetication data) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        var user = (User) auth.getPrincipal();

        var token = tokenService.generateToken(user);

        var loginResponse = new LoginResponse(token, user.getName(), user.getSurname(), user.getId(), user.getEmail());

        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid CreateRegister data) {

        if (this.userRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        User newUser = new User(data.name(), data.surname(), data.email(), encryptedPassword, data.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
