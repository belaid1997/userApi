package com.example.gestion.service;

import java.util.Optional;

import com.example.gestion.entity.TestRapport;

import java.util.List;

public interface TestService {
	
	
	
	TestRapport saveTest(TestRapport test);
	public List<TestRapport> listTest() ;
	Optional<TestRapport> findTestbyId(Long id);
	public TestRapport updatTest(TestRapport c) ;
	public void deleteTest(Long id);
	//Test loadTestByName(String name);

}
