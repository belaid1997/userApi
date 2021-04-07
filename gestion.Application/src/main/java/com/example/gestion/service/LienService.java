package com.example.gestion.service;

import java.util.List;
import java.util.Optional;

import com.example.gestion.entity.Lien;

public interface LienService {
	
	
	Lien saveLien(Lien lien);
	public List<Lien> listLien() ;
	Optional<Lien> findLienbyId(Long id);
	public Lien updatLien(Lien c) ;
	public void deleteLien(Long id);
	
	public void lancerTest();

}
