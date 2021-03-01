package com.example.minigram.service;

import com.example.minigram.dto.UserDTO;
import com.example.minigram.model.User;
import com.example.minigram.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService (UserRepository repository) {
        this.repository = repository;
    }

    public User findById (String userId) {
        return repository.findById(userId).orElse(User.EMPTY);
    }

    public UserDTO save (UserDTO userData) {
        User user = User
                .builder()
                .username(userData.getUsername())
                .password(userData.getPassword())
                .email(userData.getEmail())
                .build();

        repository.save(user);

        return UserDTO.from(user);
    }
}
