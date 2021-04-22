package com.example.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestion.entity.Archive;
import com.example.gestion.repository.ArchiveRepository;


@Service
public class ArchiveServiceImp implements ArchiveService {
	
	
	@Autowired
	ArchiveRepository archiverepo;

	@Override
	public Archive saveArchive(Archive app) {
		// TODO Auto-generated method stub
		return archiverepo.save(app);
	}

	@Override
	public List<Archive> listArchive() {
		// TODO Auto-generated method stub
		return archiverepo.findAll();
	}

	@Override
	public Optional<Archive> findbyId(Long id) {
		// TODO Auto-generated method stub
		return archiverepo.findById(id);
	}

	@Override
	public Archive updatArchive(Archive c) {
		// TODO Auto-generated method stub
		return archiverepo.save(c);
	}

	@Override
	public void deleteArchive(Long id) {
		// TODO Auto-generated method stub
		this.archiverepo.deleteById(id);
		
	}

}
