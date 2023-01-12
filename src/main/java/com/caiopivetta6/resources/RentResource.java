package com.caiopivetta6.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caiopivetta6.domain.Rent;
import com.caiopivetta6.service.RentService;

@RestController
@RequestMapping(value = "/rent")
public class RentResource {
	
	@Autowired
	private RentService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Rent> findById (@PathVariable Integer id) {
		
		Rent obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
}


