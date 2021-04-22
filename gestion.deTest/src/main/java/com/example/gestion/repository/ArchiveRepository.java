package com.example.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.gestion.entity.Archive;

@Repository
public interface ArchiveRepository extends JpaRepository<Archive, Long>{

}
