package com.example.minigram.service;

import com.example.minigram.model.User;
import com.example.minigram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User findById (String userId) {
        return repository.findById(userId).orElse(User.EMPTY);
    }
}
