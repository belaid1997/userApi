package com.example.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestion.entity.AuthantificationTest;
import com.example.gestion.repository.AuthantificationTestRepository;


@Service
public class AuthTestServiceImp implements AuthantTestService {
	
	@Autowired
	AuthantificationTestRepository authtestRepo;

	@Override
	public AuthantificationTest saveAuthTest(AuthantificationTest app) {
		// TODO Auto-generated method stub
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
