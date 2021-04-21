package com.example.gestion.service;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

import com.example.gestion.entity.Lien;

public interface LienService {
	
	
	Lien saveLien(Lien lien);
	public List<Lien> listLien() ;
	Optional<Lien> findLienbyId(Long id);
	public Lien updatLien(Lien c) ;
	public void deleteLien(Long id);
	Lien loadlienbyUrl(String lien);
	

	
	String lancerTestRapport(Lien lien) throws IOException;
	Hashtable<Long, String> lancerTest() throws IOException;

}
