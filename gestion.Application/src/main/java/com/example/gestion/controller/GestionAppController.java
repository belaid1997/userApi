package com.example.gestion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.gestion.entity.Applications;
import com.example.gestion.entity.Elements;
import com.example.gestion.entity.Lien;
import com.example.gestion.entity.Test;
import com.example.gestion.service.ApplicationsService;
import com.example.gestion.service.ElementsService;
import com.example.gestion.service.LienService;
import com.example.gestion.service.TestService;

@RestController
public class GestionAppController {
	

	@Autowired
	ApplicationsService appservice;
	@Autowired
	LienService lienservice;
	@Autowired
	ElementsService elementservice;
	@Autowired
	TestService testervice;
	
	
	//partie Application
	
	@RequestMapping(value="/app",method = RequestMethod.POST)
	public Applications saveApp(Applications app) {
		return appservice.saveApp(app);
	}
	
	
	@RequestMapping(value="/app",method = RequestMethod.GET)
	public List<Applications> listApp() {
		return appservice.listApp();
	}
	
	@RequestMapping(value="/app/{id}",method = RequestMethod.GET)
	public Optional<Applications> findById(@PathVariable Long id){
		//Optional<Applications> app=
		return appservice.findbyId(id);
	}
	@RequestMapping(value = "app/{id}",method = RequestMethod.PUT)
	public Applications updatApp(@RequestBody Applications c,@PathVariable("id") Long id) {
		c.setIdApplication(id);
		return appservice.updatApp(c);
	}
	
	@RequestMapping(value = "app/{id}",method = RequestMethod.DELETE)
	public void deleteApp(@PathVariable Long id) {
		this.appservice.deleteApp(id);
	}
	
	@RequestMapping(value="/app/name/{name}",method = RequestMethod.GET)
	public Applications loadAppByName(@PathVariable String name) {
		return appservice.loadAppByName(name);
	}
	
	
	
	////partie Lien
	
	@RequestMapping(value="/lien",method = RequestMethod.POST)
	public Lien saveLien(Lien lien) {
		return lienservice.saveLien(lien);
	}
	@RequestMapping(value="/lien",method = RequestMethod.GET)
	public List<Lien> listLien() {
		return lienservice.listLien();
	}
	
	@RequestMapping(value="/lien/{id}",method = RequestMethod.GET)
	public Optional<Lien> findLienById(@PathVariable Long id){
		
		return lienservice.findLienbyId(id);
	}
	@RequestMapping(value = "/lien/{id}",method = RequestMethod.PUT)
	public Lien updatLien(@RequestBody Lien c,@PathVariable("id") Long id) {
		c.setId(id);
		return lienservice.updatLien(c);
	}
	
	@RequestMapping(value = "/lien/{id}",method = RequestMethod.DELETE)
	public void deleteLien(@PathVariable Long id) {
		this.lienservice.deleteLien(id);
	}
	
////partie Element
	
	
	@RequestMapping(value="/element",method = RequestMethod.POST)
	public Elements saveLien(Elements lien) {
		return elementservice.saveElements(lien);
	}
	@RequestMapping(value="/element",method = RequestMethod.GET)
	public List<Elements> listElements() {
		return elementservice.listElements();
	}
	@RequestMapping(value="/element/{id}",method = RequestMethod.GET)
	public Optional<Elements> findelEmentsById(@PathVariable Long id){
		
		return elementservice.findElementsbyId(id);
	}
	@RequestMapping(value = "/element/{id}",method = RequestMethod.PUT)
	public Elements updatElements(@RequestBody Elements c,@PathVariable("id") Long id) {
		c.setId(id);
		return elementservice.updatElements(c);
	}
	
	@RequestMapping(value = "/element/{id}",method = RequestMethod.DELETE)
	public void deleteElements(@PathVariable Long id) {
		this.elementservice.deleteElements(id);
	}
	
	///////////partie test
	
	@RequestMapping(value="/test",method = RequestMethod.POST)
	public Test saveLien(Test lien) {
		return testervice.saveTest(lien);
	}
	@RequestMapping(value="/test",method = RequestMethod.GET)
	public List<Test> listTests() {
		return testervice.listTest();
	}
	@RequestMapping(value="/test/{id}",method = RequestMethod.GET)
	public Optional<Test> findTestById(@PathVariable Long id){
		
		return testervice.findTestbyId(id);
	}
	@RequestMapping(value = "/test/{id}",method = RequestMethod.PUT)
	public Test updatTests(@RequestBody Test c,@PathVariable("id") Long id) {
		c.setId(id);
		return testervice.updatTest(c);
	}
	
	@RequestMapping(value = "/test/{id}",method = RequestMethod.DELETE)
	public void deleteTests(@PathVariable Long id) {
		this.testervice.deleteTest(id);
	}
	
	
	

}
