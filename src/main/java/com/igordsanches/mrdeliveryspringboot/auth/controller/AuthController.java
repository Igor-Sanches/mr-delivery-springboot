package com.igordsanches.mrdeliveryspringboot.auth.controller;

import com.igordsanches.mrdeliveryspringboot.auth.service.UserService;
import com.igordsanches.mrdeliveryspringboot.config.jwt.JwtRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signIn")
    public ResponseEntity<?> authenticateUser(@RequestBody JwtRequest jwtRequest) {
        return userService.signin(jwtRequest);
    }

}
