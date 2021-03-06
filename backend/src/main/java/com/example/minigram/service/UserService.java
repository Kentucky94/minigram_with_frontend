package com.example.minigram.service;

import com.example.minigram.dto.UserDTO;
import com.example.minigram.model.AuthenticationRequest;
import com.example.minigram.model.AuthenticationResponse;
import com.example.minigram.model.User;
import com.example.minigram.repository.UserRepository;
import com.example.minigram.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    private final UserRepository repository;

    public UserService (UserRepository repository) {
        this.repository = repository;
    }

    public User findById (String userId) {
        return repository.findById(userId).orElse(User.EMPTY);
    }

    public UserDTO findByUsername (String username) {
        User user = repository.getByUsername(username).orElseGet(() -> User.EMPTY);

        return UserDTO.from(user);
    }

    public ResponseEntity<?> authenticate (AuthenticationRequest request) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

//        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
//        final String jwt = jwtTokenUtil.generateToken(userDetails);
//        return ResponseEntity.ok(new AuthenticationResponse(jwt));

        final UserDTO dto = findByUsername(request.getUsername());
        final String token = jwtTokenUtil.generateToken(dto);

        return ResponseEntity.ok(AuthenticationResponse.from(dto, token));
    }

    public UserDTO save (UserDTO userData) {
        User user = User
                .builder()
                .username(userData.getUsername())
                .password(passwordEncoder.encode(userData.getPassword()))
                .email(userData.getEmail())
                .build();

        repository.save(user);

        return UserDTO.from(user);
    }
}
