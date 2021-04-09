package com.example.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestion.entity.TestRapport;

@Repository
public interface TestRepository extends JpaRepository<TestRapport, Long> {

}
