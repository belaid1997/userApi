package com.example.gestion.service;

import java.util.List;
import java.util.Optional;

import com.example.gestion.entity.Elements;

public interface ElementsService {
	
	
	
	Elements saveElements(Elements elements);
	public List<Elements> listElements() ;
	Optional<Elements> findElementsbyId(Long id);
	public Elements updatElements(Elements c) ;
	public void deleteElements(Long id);


}
