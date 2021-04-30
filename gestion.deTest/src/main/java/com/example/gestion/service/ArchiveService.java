package com.example.gestion.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.example.gestion.entity.Archive;

public interface ArchiveService {
	
	
	Archive saveArchive(Archive app);
	public List<Archive> listArchive() ;
	Optional<Archive> findbyId(Long id);
	public Archive updatArchive(Archive c) ;
	public void deleteArchive(Long id);
	
	

}
