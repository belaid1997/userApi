package com.example.gestion.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestion.entity.Archive;
import com.example.gestion.entity.Lien;
import com.example.gestion.repository.ArchiveRepository;
import com.example.gestion.service.ArchiveService;

@RestController
public class ArchiveController {
	@Autowired
	ArchiveService archservice;
	@Autowired
	ArchiveRepository archRepo;
	
	@RequestMapping(value="/archive",method = RequestMethod.POST)
	public Archive saveArchive(@RequestBody Archive Archive) {
		return archservice.saveArchive(Archive);
	}
	
	
	@RequestMapping(value="/archive",method = RequestMethod.GET)
	public List<Archive> listArchive() {
		return archservice.listArchive();
	}
	
	@RequestMapping(value="/archive/{id}",method = RequestMethod.GET)
	public Optional<Archive> findById(@PathVariable Long id){
		//Optional<Archive> Archive=
		return archservice.findbyId(id);
	}
	@RequestMapping(value = "archive/{id}",method = RequestMethod.PUT)
	public Archive updatArchive(@RequestBody Archive c,@PathVariable("id") Long id) {
		Archive archive=archservice.findbyId(id).get();
		
		
		
		
		return archservice.updatArchive(archive);
	}
	
	@RequestMapping(value = "archive/{id}",method = RequestMethod.DELETE)
	public void deleteArchive(@PathVariable Long id) {
		this.archservice.deleteArchive(id);
	}
	
	@RequestMapping(value="/archive/datetest",method = RequestMethod.GET)
	//http://localhost:8080/archive/datetest?date=2021-04-29 just pour comprendre
	public List<Archive> loadArchivebyDatetest(@RequestParam("date")  
	@DateTimeFormat(pattern = "yyyy-MM-dd")java.util.Date date){
	//	Date date=Date.valueOf(dates);
		return archRepo.findAllByDatetest(date);
	}
	
	
	@GetMapping("/getalltestbetween")
	//http://localhost:8080/getalltestbetween?startdate=2021-04-25&enddate=2021-04-28 
	public List getAllByDatetimeBetween(
			@RequestParam("startdate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startdate,
			@RequestParam("enddate") @DateTimeFormat(pattern="yyyy-MM-dd") Date enddate) {
		
		return archRepo.findAllByDatetestBetween(startdate, enddate);
	}
	
	
	
	
	

}
