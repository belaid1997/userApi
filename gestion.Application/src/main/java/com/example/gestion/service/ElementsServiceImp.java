package com.example.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestion.entity.Elements;
import com.example.gestion.repository.ElementsRepository;



@Service
public class ElementsServiceImp implements ElementsService {
	
	
	@Autowired
	ElementsRepository elementsRepository;

	@Override
	public Elements saveElements(Elements elements) {
		// TODO Auto-generated method stub
		return elementsRepository.save(elements);
	}

	@Override
	public List<Elements> listElements() {
		// TODO Auto-generated method stub
		return elementsRepository.findAll();
	}

	@Override
	public Optional<Elements> findElementsbyId(Long id) {
		// TODO Auto-generated method stub
		return elementsRepository.findById(id);
	}

	@Override
	public Elements updatElements(Elements c) {
		// TODO Auto-generated method stub
		return elementsRepository.save(c);
	}

	@Override
	public void deleteElements(Long id) {
		// TODO Auto-generated method stub
		this.elementsRepository.deleteById(id);
		
	}

}
