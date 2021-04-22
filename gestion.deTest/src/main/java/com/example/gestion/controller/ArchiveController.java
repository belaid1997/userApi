package com.example.gestion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestion.entity.Archive;
import com.example.gestion.service.ArchiveService;

@RestController
public class ArchiveController {
	@Autowired
	ArchiveService archservice;
	
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
	
	
	

}
