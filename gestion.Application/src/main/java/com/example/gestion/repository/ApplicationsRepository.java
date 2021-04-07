package com.example.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestion.entity.Applications;


@Repository
public interface ApplicationsRepository extends JpaRepository<Applications, Long>{
	
	Applications findByApplicationName(String name);

}
