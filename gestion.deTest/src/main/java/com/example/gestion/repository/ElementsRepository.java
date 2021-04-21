package com.example.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestion.entity.Elements;

@Repository
public interface ElementsRepository extends JpaRepository<Elements, Long> {

}
