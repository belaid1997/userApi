package com.example.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestion.entity.TestType;

@Repository
public interface TestTypeRepository extends JpaRepository<TestType, Long>{

}
