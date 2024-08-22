package com.igordsanches.mrdeliveryspringboot.auth.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
public class User implements UserDetails {
    private static final long serialVersionUID = 10910939029292323L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;
    private String password;
    private String email;
    private boolean active;
    private String token;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}
