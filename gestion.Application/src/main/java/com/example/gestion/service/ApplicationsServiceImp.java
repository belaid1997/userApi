package com.example.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestion.entity.Applications;
import com.example.gestion.repository.ApplicationsRepository;



@Service
public class ApplicationsServiceImp implements ApplicationsService {
	
	
	@Autowired
    private ApplicationsRepository appRepository;

	
	@Override
	public Applications saveApp(Applications app) {
		// TODO Auto-generated method stub
		return appRepository.save(app);
	}

	@Override
	public List<Applications> listApp() {
		// TODO Auto-generated method stub
		return appRepository.findAll();
	}

	@Override
	public Optional<Applications> findbyId(Long id) {
		// TODO Auto-generated method stub
		return appRepository.findById(id);
	}

	@Override
	public Applications updatApp(Applications c) {
		// TODO Auto-generated method stub
		return appRepository.save(c);
	}

	@Override
	public void deleteApp(Long id) {
		// TODO Auto-generated method stub
		this.appRepository.deleteById(id);
	}

	@Override
	public Applications loadAppByName(String name) {
		// TODO Auto-generated method stub
		return appRepository.findByApplicationName(name);
	}

}
