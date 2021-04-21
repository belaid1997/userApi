package com.example.gestion.service;

import java.util.List;
import java.util.Optional;

import com.example.gestion.entity.LoopTest;

public interface LoopTestService {
	
	
	
	LoopTest saveLoop(LoopTest app);
	public List<LoopTest> listLoop() ;
	Optional<LoopTest> findLoopbyId(Long id);
	public LoopTest updatLoop(LoopTest c) ;
	public void deleteLoop(Long id);

}
