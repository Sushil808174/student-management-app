package com.studentManagement.repository;

import com.studentManagement.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    public Optional<Admin> findByEmail(String email);
}
