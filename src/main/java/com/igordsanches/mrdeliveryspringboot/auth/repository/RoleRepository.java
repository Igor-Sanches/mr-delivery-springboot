package com.igordsanches.mrdeliveryspringboot.auth.repository;

import com.igordsanches.mrdeliveryspringboot.auth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
