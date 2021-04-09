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
import com.example.gestion.entity.AuthantificationTest;
import com.example.gestion.entity.Elements;
import com.example.gestion.entity.Lien;
import com.example.gestion.entity.LoopTest;
import com.example.gestion.entity.TestRapport;
import com.example.gestion.entity.TestType;
import com.example.gestion.repository.TestTypeRepository;
import com.example.gestion.service.ApplicationsService;
import com.example.gestion.service.AuthantTestService;
import com.example.gestion.service.ElementsService;
import com.example.gestion.service.LienService;
import com.example.gestion.service.LoopTestService;
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
	@Autowired
	LoopTestService Loopservice;
	@Autowired
	AuthantTestService authTestervice;
	@Autowired
	TestTypeRepository testTypeRepo;
	
	
	//partie Application
	
	@RequestMapping(value="/app",method = RequestMethod.POST)
	public Applications saveApp(@RequestBody Applications app) {
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
		Optional<Applications> app=appservice.findbyId(id);
		Applications ap=app.get();
		if(c.getApplicationName()==null) {c.setApplicationName(ap.getApplicationName());}
		if(c.getDateAjoute()==null) {c.setDateAjoute(ap.getDateAjoute());}
		
		
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
	public Lien saveLien(@RequestBody Lien lien) {
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
		Optional<Lien> lin=lienservice.findLienbyId(id);
		Lien lien=lin.get();
		Applications app=appservice.findbyId(lien.getApplication()).get();
		TestType type=testTypeRepo.findById(lien.getTestTypeid()).get();
	
		if(c.getUrl()==null) {c.setUrl(lien.getUrl());}
		if(c.getApplication()==null) {c.setApplication(app);}
		//if(c.getTestType()==null) {c.setTestType(type);}
	
		return lienservice.updatLien(c);
	}
	
	@RequestMapping(value = "/lien/{id}",method = RequestMethod.DELETE)
	public void deleteLien(@PathVariable Long id) {
		this.lienservice.deleteLien(id);
	}
	
////partie Element
	
	
	@RequestMapping(value="/element",method = RequestMethod.POST)
	public Elements saveLien(@RequestBody Elements lien) {
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
	public Elements updatElements(@RequestBody Elements c,@PathVariable("id") Long id) throws NullPointerException {
		c.setId(id);
		Elements ele=elementservice.findElementsbyId(id).get();
		if(c.getCssSelector()==null) {c.setCssSelector(ele.getCssSelector());}
		if(c.getIdlocator()==null) {c.setIdlocator(ele.getIdlocator());}
		if(c.getNamelocator()==null) {c.setNamelocator(ele.getNamelocator());}
		if(c.getTagenamelocator()==null) {c.setTagenamelocator(ele.getTagenamelocator());}
		if(c.getTagenamelocator()==null) {c.setTagenamelocator(ele.getTagenamelocator());}
		if(c.getXpath()==null) {c.setXpath(ele.getXpath());}
		if(c.getValue()==null) {c.setValue(ele.getValue());}
		
		
		
		return elementservice.updatElements(c);
	}
	
	@RequestMapping(value = "/element/{id}",method = RequestMethod.DELETE)
	public void deleteElements(@PathVariable Long id) {
		this.elementservice.deleteElements(id);
	}
	
	
	
	////////////partie Auth Test
	@RequestMapping(value="/authtest",method = RequestMethod.POST)
	public AuthantificationTest saveAuthTest(@RequestBody AuthantificationTest lien) {
		return authTestervice.saveAuthTest(lien);
	}
	@RequestMapping(value="/authtest",method = RequestMethod.GET)
	public List<AuthantificationTest> listAuthTest() {
		return authTestervice.listAuthTest();
	}
	@RequestMapping(value="/authtest/{id}",method = RequestMethod.GET)
	public Optional<AuthantificationTest> findAuthTestById(@PathVariable Long id){
		
		return authTestervice.findAuthTestbyId(id);
	}
	@RequestMapping(value = "/authtest/{id}",method = RequestMethod.PUT)
	public AuthantificationTest updatAuthTest(@RequestBody AuthantificationTest c,@PathVariable("id") Long id) {
		c.setId(id);
		return authTestervice.updatAuthTest(c);
	}
	
	@RequestMapping(value = "/authtest/{id}",method = RequestMethod.DELETE)
	public void deleteAuthTest(@PathVariable Long id) {
		this.authTestervice.deleteAuthTest(id);
	}
	
	
	/////////Partie Loop test
	
	@RequestMapping(value="/loop",method = RequestMethod.POST)
	public LoopTest saveLoop(@RequestBody LoopTest lien) {
		return Loopservice.saveLoop(lien);
	}
	@RequestMapping(value="/loop",method = RequestMethod.GET)
	public List<LoopTest> listLoop() {
		return Loopservice.listLoop();
	}
	@RequestMapping(value="/loop/{id}",method = RequestMethod.GET)
	public Optional<LoopTest> findLoopById(@PathVariable Long id){
		
		return Loopservice.findLoopbyId(id);
	}
	@RequestMapping(value = "/loop/{id}",method = RequestMethod.PUT)
	public LoopTest updatLoop(@RequestBody LoopTest c,@PathVariable("id") Long id) {
		
		return Loopservice.updatLoop(c);
	}
	
	@RequestMapping(value = "/loop/{id}",method = RequestMethod.DELETE)
	public void deleteLoop(@PathVariable Long id) {
		this.Loopservice.deleteLoop(id);
	}
	
	
	///////////partie test
	
	@RequestMapping(value="/test",method = RequestMethod.POST)
	public TestRapport saveLien(@RequestBody TestRapport lien) {
		return testervice.saveTest(lien);
	}
	@RequestMapping(value="/test",method = RequestMethod.GET)
	public List<TestRapport> listTests() {
		return testervice.listTest();
	}
	@RequestMapping(value="/test/{id}",method = RequestMethod.GET)
	public Optional<TestRapport> findTestById(@PathVariable Long id){
		
		return testervice.findTestbyId(id);
	}
	@RequestMapping(value = "/test/{id}",method = RequestMethod.PUT)
	public TestRapport updatTests(@RequestBody TestRapport c,@PathVariable("id") Long id) {
		c.setId(id);
		return testervice.updatTest(c);
	}
	
	@RequestMapping(value = "/test/{id}",method = RequestMethod.DELETE)
	public void deleteTests(@PathVariable Long id) {
		this.testervice.deleteTest(id);
	}
	
	
	

}
