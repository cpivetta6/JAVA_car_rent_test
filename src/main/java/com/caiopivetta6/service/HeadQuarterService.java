package com.caiopivetta6.service;

import java.util.Optional;

import com.caiopivetta6.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiopivetta6.domain.HeadQuarter;
import com.caiopivetta6.repositories.HeadQuarterRepository;

@Service
public class HeadQuarterService {
	
	@Autowired
	private HeadQuarterRepository repository;
	
	public HeadQuarter find(Integer id) {
		
		Optional<HeadQuarter> obj = repository.findById(id);
		
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Tipo: " + HeadQuarter.class.getName()));

	}
}
