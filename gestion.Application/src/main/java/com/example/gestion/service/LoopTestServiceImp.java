package com.example.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestion.entity.LoopTest;
import com.example.gestion.repository.LoopTestRepository;


@Service
public class LoopTestServiceImp implements LoopTestService {
	
	
	@Autowired
	LoopTestRepository loopttestrepo;

	@Override
	public LoopTest saveLoop(LoopTest app) {
		// TODO Auto-generated method stub
		return loopttestrepo.save(app);
	}

	@Override
	public List<LoopTest> listLoop() {
		// TODO Auto-generated method stub
		return loopttestrepo.findAll();
	}

	@Override
	public Optional<LoopTest> findLoopbyId(Long id) {
		// TODO Auto-generated method stub
		return loopttestrepo.findById(id);
	}

	@Override
	public LoopTest updatLoop(LoopTest c) {
		// TODO Auto-generated method stub
		return loopttestrepo.save(c);
	}

	@Override
	public void deleteLoop(Long id) {
		// TODO Auto-generated method stub
		this.loopttestrepo.deleteById(id);
		
	}

}
