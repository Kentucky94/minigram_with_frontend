package com.example.minigram.model;

import com.example.minigram.dto.UserDTO;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
@Builder
public class AuthenticationResponse {
    public static AuthenticationResponse from (UserDTO dto, String token) {
        return builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .roles(dto.getRoles())
                .token(token)
                .build();
    }

    private String id;
    private String username;
    private String email;
    private String token;
    private List<GrantedAuthority> roles;
}
