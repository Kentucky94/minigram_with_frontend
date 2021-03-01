package com.example.minigram.service;

import com.example.minigram.model.MyUserDetails;
import com.example.minigram.model.User;
import com.example.minigram.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optUser = userRepository.getByUsername(username);

        User user = optUser.orElseGet(() -> {
            throw new UsernameNotFoundException("NOT FOUND");
        });

        return MyUserDetails.from(user);
    }
}
