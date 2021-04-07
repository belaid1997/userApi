package com.example.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestion.entity.Lien;

@Repository
public interface LienRepository extends JpaRepository<Lien, Long> {

}
