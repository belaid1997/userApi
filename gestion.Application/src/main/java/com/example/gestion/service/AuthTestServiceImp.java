package com.example.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestion.entity.AuthantificationTest;
import com.example.gestion.entity.Elements;
import com.example.gestion.repository.AuthantificationTestRepository;
import com.example.gestion.repository.ElementsRepository;


@Service
public class AuthTestServiceImp implements AuthantTestService {
	
	@Autowired
	AuthantificationTestRepository authtestRepo;
	@Autowired
	ElementsRepository elementRepo;

	@Override
	public AuthantificationTest saveAuthTest(AuthantificationTest app) {
		// TODO Auto-generated method stub
		Elements u= elementRepo.getOne(app.getUsername().getId()); //try catch pour la gestion des exptions cheked
		Elements p= elementRepo.getOne(app.getPassword().getId());
		Elements b= elementRepo.getOne(app.getBotton().getId());
		app.setUsername(u);
		app.setPassword(p);
		app.setPassword(p);
		
		
		return authtestRepo.save(app);
	}

	@Override
	public List<AuthantificationTest> listAuthTest() {
		// TODO Auto-generated method stub
		return authtestRepo.findAll();
	}

	@Override
	public Optional<AuthantificationTest> findAuthTestbyId(Long id) {
		// TODO Auto-generated method stub
		return authtestRepo.findById(id);
	}

	@Override
	public AuthantificationTest updatAuthTest(AuthantificationTest c) {
		// TODO Auto-generated method stub
		return authtestRepo.save(c);
	}

	@Override
	public void deleteAuthTest(Long id) {
		// TODO Auto-generated method stub
		this.authtestRepo.deleteById(id);
		
	}

	
	
	
	
	

}
