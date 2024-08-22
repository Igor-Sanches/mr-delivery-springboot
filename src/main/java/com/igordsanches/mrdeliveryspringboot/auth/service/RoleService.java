package com.igordsanches.mrdeliveryspringboot.auth.service;

import com.igordsanches.mrdeliveryspringboot.auth.entity.Role;
import com.igordsanches.mrdeliveryspringboot.auth.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
