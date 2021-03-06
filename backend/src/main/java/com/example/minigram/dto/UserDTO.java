package com.example.minigram.dto;

import com.example.minigram.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    public static UserDTO from(User user) {
        List<GrantedAuthority> list = List.of(new SimpleGrantedAuthority(user.getRoles()));

        return builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .roles(list)
                .build();
    }

    private String id;
    private String username;
    private String password;
    private String email;
    private String token;
    private List<GrantedAuthority> roles;
}
