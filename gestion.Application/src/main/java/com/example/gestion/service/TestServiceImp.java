package com.example.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestion.entity.Test;
import com.example.gestion.repository.TestRepository;

@Service
public class TestServiceImp implements TestService {
	
	
	@Autowired
	TestRepository testRepository;

	@Override
	public Test saveTest(Test test) {
		// TODO Auto-generated method stub
		return testRepository.save(test);
	}

	@Override
	public List<Test> listTest() {
		// TODO Auto-generated method stub
		return testRepository.findAll();
	}

	@Override
	public Optional<Test> findTestbyId(Long id) {
		// TODO Auto-generated method stub
		return testRepository.findById(id);
	}

	@Override
	public Test updatTest(Test c) {
		// TODO Auto-generated method stub
		return testRepository.save(c);
	}

	@Override
	public void deleteTest(Long id) {
		// TODO Auto-generated method stub
		this.testRepository.deleteById(id);
		
	}
	
	
	
	
	
	
	

}
