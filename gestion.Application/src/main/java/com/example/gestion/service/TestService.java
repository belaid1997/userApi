package com.example.gestion.service;

import java.util.Optional;

import com.example.gestion.entity.Test;

import java.util.List;

public interface TestService {
	
	
	
	Test saveTest(Test test);
	public List<Test> listTest() ;
	Optional<Test> findTestbyId(Long id);
	public Test updatTest(Test c) ;
	public void deleteTest(Long id);
	//Test loadTestByName(String name);

}
