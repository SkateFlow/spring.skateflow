package com.skateflow.Skateflow.repository;


import com.skateflow.Skateflow.model.AdminLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRequestRepository extends JpaRepository<AdminLogin, Long> {
    Optional<AdminLogin> findByUsernameAndPassword(String username, String password);
}

