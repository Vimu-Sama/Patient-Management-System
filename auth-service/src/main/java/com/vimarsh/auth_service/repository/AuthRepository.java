package com.vimarsh.auth_service.repository;

import com.vimarsh.auth_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuthRepository extends JpaRepository<User, UUID> {
    public Optional<User> findByUserEmail(String email) ;
    public Optional<User> deleteByUserEmail(String email) ;
}
