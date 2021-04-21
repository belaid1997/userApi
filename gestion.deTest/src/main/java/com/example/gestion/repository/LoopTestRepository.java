package com.example.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestion.entity.LoopTest;


@Repository
public interface LoopTestRepository extends JpaRepository<LoopTest, Long> {

}
