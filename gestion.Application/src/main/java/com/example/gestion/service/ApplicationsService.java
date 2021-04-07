package com.example.gestion.service;

import java.util.List;
import java.util.Optional;


import com.example.gestion.entity.Applications;


public interface ApplicationsService {
	
	
	
	Applications saveApp(Applications app);
	public List<Applications> listApp() ;
	Optional<Applications> findbyId(Long id);
	public Applications updatApp(Applications c) ;
	public void deleteApp(Long id);
	Applications loadAppByName(String name);
	
	


}
