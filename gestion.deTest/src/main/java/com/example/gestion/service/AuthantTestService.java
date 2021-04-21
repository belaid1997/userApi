package com.example.gestion.service;

import java.util.List;
import java.util.Optional;

import com.example.gestion.entity.AuthantificationTest;

public interface AuthantTestService {
	
	AuthantificationTest saveAuthTest(AuthantificationTest app);
	public List<AuthantificationTest> listAuthTest() ;
	Optional<AuthantificationTest> findAuthTestbyId(Long id);
	public AuthantificationTest updatAuthTest(AuthantificationTest c) ;
	public void deleteAuthTest(Long id);
	

}
