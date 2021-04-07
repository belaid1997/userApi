package com.example.gestion.service;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.gestion.entity.Lien;
import com.example.gestion.repository.LienRepository;






@Service
public class LienServiceImp implements LienService{
	
	@Autowired
	LienRepository lienrepository;

	@Override
	public Lien saveLien(Lien lien) {
		// TODO Auto-generated method stub
		return lienrepository.save(lien);
	}

	@Override
	public List<Lien> listLien() {
		// TODO Auto-generated method stub
		return lienrepository.findAll();
	}

	@Override
	public Optional<Lien> findLienbyId(Long id) {
		// TODO Auto-generated method stub
		return lienrepository.findById(id);
	}

	@Override
	public Lien updatLien(Lien c) {
		// TODO Auto-generated method stub
		return lienrepository.save(c);
	}

	@Override
	public void deleteLien(Long id) {
		// TODO Auto-generated method stub
		this.lienrepository.deleteById(id);
	}
////////////******************************
	////////////partie test des lien
	@Override
	public void lancerTest() {
		// TODO Auto-generated method stub
		List<Lien> lien;
		lien=lienrepository.findAll();
	 }
		
	

		
		
		
		
		
		
		
		
		
		

}
