package com.igordsanches.mrdeliveryspringboot.auth.repository;

import com.igordsanches.mrdeliveryspringboot.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
