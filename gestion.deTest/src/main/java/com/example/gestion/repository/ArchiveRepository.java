package com.example.gestion.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.gestion.entity.Archive;

@Repository
public interface ArchiveRepository extends JpaRepository<Archive, Long>{

	List<Archive> findAllByDatetest(Date date);
	List<Archive> findAllByDatetestBetween(
			Date dateTimeStart,
			Date dateTimeEnd);
	

}
