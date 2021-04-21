package com.example.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestion.entity.AuthantificationTest;

@Repository
public interface AuthantificationTestRepository extends JpaRepository<AuthantificationTest, Long> {

}
