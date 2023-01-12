package com.caiopivetta6.service;

import java.util.Optional;

import com.caiopivetta6.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiopivetta6.domain.Rent;
import com.caiopivetta6.repositories.RentRepository;

@Service
public class RentService {
	
	@Autowired
	private RentRepository repository;
	
	public Rent find(Integer id) {
		
		Optional<Rent> obj = repository.findById(id);
		
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Tipo: " + Rent.class.getName()));

	}
}
