package com.example.minigram.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyUserDetails implements UserDetails {
    public static MyUserDetails from (User user) {
        List<GrantedAuthority> list = List.of(new SimpleGrantedAuthority(user.getRoles()));

        return builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(list)
                .active(user.isActive())
                .build();
    }

    private String username;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities () {
        return this.authorities;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }
}
