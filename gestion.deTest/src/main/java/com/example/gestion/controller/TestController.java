package com.example.gestion.controller;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestion.entity.Applications;
import com.example.gestion.entity.Lien;
import com.example.gestion.entity.TestRapport;
import com.example.gestion.repository.TestTypeRepository;
import com.example.gestion.service.ApplicationsService;
import com.example.gestion.service.AuthantTestService;
import com.example.gestion.service.ElementsService;
import com.example.gestion.service.LienService;
import com.example.gestion.service.LoopTestService;
import com.example.gestion.service.TestService;

@RestController
public class TestController {
	
	
	@Autowired
	ApplicationsService appservice;
	@Autowired
	LienService lienservice;
	@Autowired
	ElementsService elementservice;
	@Autowired
	TestService testervice;
	@Autowired
	LoopTestService Loopservice;
	@Autowired
	AuthantTestService authTestervice;
	@Autowired
	TestTypeRepository testTypeRepo;
	
	@RequestMapping(value="/lancertest/{lien}",method = RequestMethod.GET)
	public String lancerTestRapport(@PathVariable Long lien) throws IOException{
		
		Lien e=lienservice.findLienbyId(lien).get();
		
		return lienservice.lancerTestRapport(e);
	}
	
	@RequestMapping(value="/lancertest/",method = RequestMethod.GET)
	public Hashtable<Long, String> lancerTest() throws IOException{
		
		
		
		return lienservice.lancerTest();
	}












}
