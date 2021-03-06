package com.example.minigram.controller;

import com.example.minigram.dto.UserDTO;
import com.example.minigram.model.AuthenticationRequest;
import com.example.minigram.repository.UserRepository;
import com.example.minigram.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository repository;
    private final UserService service;

    public UserController (UserRepository repository, UserService service) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO createUser (@RequestBody UserDTO userData) {
        return service.save(userData);
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> authenticateUser (@RequestBody AuthenticationRequest request) throws Exception {
        return service.authenticate(request);
    }
}
