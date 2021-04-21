package com.example.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestion.entity.TestRapport;
import com.example.gestion.repository.TestRepository;

@Service
public class TestServiceImp implements TestService {
	
	
	@Autowired
	TestRepository testRepository;

	@Override
	public TestRapport saveTest(TestRapport test) {
		// TODO Auto-generated method stub
		return testRepository.save(test);
	}

	@Override
	public List<TestRapport> listTest() {
		// TODO Auto-generated method stub
		return testRepository.findAll();
	}

	@Override
	public Optional<TestRapport> findTestbyId(Long id) {
		// TODO Auto-generated method stub
		return testRepository.findById(id);
	}

	@Override
	public TestRapport updatTest(TestRapport c) {
		// TODO Auto-generated method stub
		return testRepository.save(c);
	}

	@Override
	public void deleteTest(Long id) {
		// TODO Auto-generated method stub
		this.testRepository.deleteById(id);
		
	}
	
	
	
	
	
	
	

}
