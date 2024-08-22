package com.igordsanches.mrdeliveryspringboot.auth.service;

import com.igordsanches.mrdeliveryspringboot.auth.entity.User;
import com.igordsanches.mrdeliveryspringboot.auth.repository.UserRepository;
import com.igordsanches.mrdeliveryspringboot.config.jwt.JwtRequest;
import com.igordsanches.mrdeliveryspringboot.config.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public ResponseEntity<?> signin(JwtRequest authenticateRequest) {
        try{
            authenticate(authenticateRequest.getUsername(), authenticateRequest.getPassword());

            final User userDetails = userRepository.findByUsername(authenticateRequest.getUsername());

            final String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(token);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(e.getMessage());
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (DisabledException e){
            throw new Exception("Usuario nāo encontrado");
        }catch (BadCredentialsException e){
            throw new Exception("Dados incorretos");
        }
    }

}
