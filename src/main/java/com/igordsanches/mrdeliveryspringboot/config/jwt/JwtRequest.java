package com.igordsanches.mrdeliveryspringboot.config.jwt;

import lombok.Data;

@Data
public class JwtRequest {
    private String username, password;
}
