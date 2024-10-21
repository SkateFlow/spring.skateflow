package com.skateflow.Skateflow.repository;

import com.skateflow.Skateflow.model.AdminLogin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AdminLoginRepository extends JpaRepository<AdminLogin, Long> {
}
