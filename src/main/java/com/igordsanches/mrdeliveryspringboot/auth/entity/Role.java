package com.igordsanches.mrdeliveryspringboot.auth.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class Role implements GrantedAuthority {

    private static final long serialVersionUID = 1923923923923L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Override
    public String getAuthority() {
        return "";
    }
}
